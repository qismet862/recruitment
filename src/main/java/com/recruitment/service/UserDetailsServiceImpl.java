package com.recruitment.service;


import com.recruitment.constant.Role;
import com.recruitment.entity.AdminEntity;
import com.recruitment.entity.AdminTokenEntity;
import com.recruitment.entity.TokenEntity;
import com.recruitment.entity.UserEntity;
import com.recruitment.repository.AdminTokenRepository;
import com.recruitment.repository.TokenRepository;
import com.recruitment.security.UserPrincipal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final TokenRepository tokenRepository;

    private final AdminTokenRepository adminTokenRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        Optional<TokenEntity> optionalTokenEntity = tokenRepository.findById(token);
        if (optionalTokenEntity.isPresent()) {
            UserEntity user = optionalTokenEntity.get().getUser();
            return new UserPrincipal(user, Role.ROLE_USER);
        }
        Optional<AdminTokenEntity> optionalAdminTokenEntity = adminTokenRepository.findById(token);
        if (optionalAdminTokenEntity.isPresent()) {
            AdminEntity admin = optionalAdminTokenEntity.get().getAdmin();
            return new UserPrincipal(admin, Role.ROLE_ADMIN);
        }
        return null;
    }
}
