package com.recruitment.service;

import com.recruitment.dto.request.LoginRequest;
import com.recruitment.dto.response.LoginResponse;
import com.recruitment.entity.AdminEntity;
import com.recruitment.entity.AdminTokenEntity;
import com.recruitment.entity.TokenEntity;
import com.recruitment.entity.UserEntity;
import com.recruitment.exception.AuthenticationException;
import com.recruitment.mapper.AdminMapper;
import com.recruitment.mapper.UserMapper;
import com.recruitment.repository.AdminRepository;
import com.recruitment.repository.AdminTokenRepository;
import com.recruitment.repository.TokenRepository;
import com.recruitment.repository.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    private final UserMapper userMapper;

    private final AdminTokenRepository adminTokenRepository;

    private final AdminRepository adminRepository;

    private final AdminMapper adminMapper;

    public LoginResponse login(LoginRequest request) {

        var adminEntity = adminRepository.findByUserName(request.getUserName());
        if (adminEntity.isPresent()) {
            boolean auth = passwordEncoder.matches(request.getPassword(), adminEntity.get().getPassword());
            if (auth) {
                return adminLogin(request, adminEntity.get());
            }
        }

        UserEntity userEntity = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new AuthenticationException("Unauthorized"));

        boolean auth = passwordEncoder.matches(request.getPassword(), userEntity.getPassword());
        if (!auth) {
            throw new AuthenticationException("Unauthorized");
        }

        String token = generateRandomToken();

        TokenEntity tokenEntity = TokenEntity.builder()
                .token(token)
                .user(userEntity).build();
        tokenRepository.save(tokenEntity);

        var userLoginResponse = userMapper.toLoginResponse(userEntity);

        LoginResponse loginResponse = LoginResponse.builder()
                .role("user")
                .token(token)
                .object(userLoginResponse).build();

        return loginResponse;
    }

    public LoginResponse adminLogin(LoginRequest request, AdminEntity adminEntity) {
        String token = generateRandomToken();

        AdminTokenEntity adminTokenEntity = AdminTokenEntity.builder()
                .token(token)
                .admin(adminEntity).build();
        adminTokenRepository.save(adminTokenEntity);

        var adminLoginResponse = adminMapper.toLoginResponse(adminEntity);

        LoginResponse loginResponse = LoginResponse.builder()
                .role("admin")
                .token(token)
                .object(adminLoginResponse).build();
        return loginResponse;
    }

    public String generateRandomToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void logout(String token) {
        tokenRepository.deleteById(token.substring(7));
    }
}
