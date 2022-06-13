package com.recruitment.service;

import com.recruitment.dto.request.AdminUpdateRequest;
import com.recruitment.dto.request.UpdateRequest;
import com.recruitment.dto.request.UserRequest;
import com.recruitment.dto.response.LoginResponse;
import com.recruitment.dto.response.UserDetailsResponse;
import com.recruitment.dto.response.UserResponse;
import com.recruitment.entity.AddressEntity;
import com.recruitment.entity.TechnologyEntity;
import com.recruitment.entity.UserEntity;
import com.recruitment.exception.CustomNotFoundException;
import com.recruitment.exception.UniqueUserName;
import com.recruitment.file.FileSaver;
import com.recruitment.mapper.UserMapper;
import com.recruitment.repository.AddressRepository;
import com.recruitment.repository.TechnologyRepository;
import com.recruitment.repository.UserRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final TechnologyRepository technologyRepository;

    private final AddressRepository addressRepository;

    private final UserMapper userMapper;

    private final FileSaver fileSaver;

    private final PasswordEncoder passwordEncoder;

    String path = "\\cv\\";

    public void signup(UserRequest userRequest, MultipartFile file) {
        Optional<UserEntity> checkUser = userRepository.findByUserName(userRequest.getUserName());
        if (checkUser.isPresent()) {
            throw new UniqueUserName("UserName already exist");
        }
        Iterable<Long> id = getIterableFromIterator(userRequest.getTechId().iterator());
        List<TechnologyEntity> technologyEntityList = technologyRepository.findAllById(id);
        AddressEntity address = addressRepository.findById(userRequest.getAddressId())
                .orElseThrow(() -> new CustomNotFoundException("Address not found"));
        var userEntity = userMapper.toEntity(userRequest);
        String filePath = fileSaver.saveAndGetPath(file, path);
        userEntity.setTechnologyId(technologyEntityList);
        userEntity.setAddress(address);
        userEntity.setCvUrl(filePath);
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(userEntity);
    }

    public static <T> Iterable<T> getIterableFromIterator(Iterator<T> iterator) {
        return () -> iterator;
    }

    public LoginResponse update(UpdateRequest updateRequest, MultipartFile file, Long id, String token) {
        updateRequest.setId(id);
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("User not found"));

        UserEntity editedUser = userMapper.toUserEntity(updateRequest);

        Iterable<Long> techId = getIterableFromIterator(updateRequest.getTechId().iterator());
        List<TechnologyEntity> technologyEntityList = technologyRepository.findAllById(techId);
        AddressEntity address = addressRepository.findById(updateRequest.getAddressId())
                .orElseThrow(() -> new CustomNotFoundException("Address not found"));

        editedUser.setTechnologyId(technologyEntityList);
        editedUser.setAddress(address);
        editedUser.setPassword(user.getPassword());
        if (file != null) {
            fileSaver.deleteFile(user.getCvUrl());
            editedUser.setCvUrl(fileSaver.saveAndGetPath(file, path));
        }
        userRepository.save(editedUser);
        var userLoginResponse = userMapper.toLoginResponse(editedUser);

        LoginResponse loginResponse = LoginResponse.builder()
                .token(token)
                .role("user")
                .object(userLoginResponse).build();
        return loginResponse;
    }

    public List<UserResponse> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> responseList = userMapper.toUserResponses(users);
        return responseList;
    }

    public UserDetailsResponse getUser(Long id) {
        UserEntity user = userRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("User not found"));

        return userMapper.toUserDetail(user);
    }

    public void updateByAdmin(AdminUpdateRequest request, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("User Not Found"));

        Optional<UserEntity> checkUser = userRepository.findByUserName(request.getUserName());
        if (checkUser.isPresent()) {
            throw new UniqueUserName("UserName already exist");
        }

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setUserName(request.getUserName());

        userRepository.save(user);
    }
}
