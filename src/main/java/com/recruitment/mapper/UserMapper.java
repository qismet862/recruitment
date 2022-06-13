package com.recruitment.mapper;

import com.recruitment.dto.request.UpdateRequest;
import com.recruitment.dto.request.UserRequest;
import com.recruitment.dto.response.UserDetailsResponse;
import com.recruitment.dto.response.UserLoginResponse;
import com.recruitment.dto.response.UserResponse;
import com.recruitment.entity.UserEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity toEntity(UserRequest userRequest);

    @Mapping(target = "technology", source = "technologyId")
    UserLoginResponse toLoginResponse(UserEntity userEntity);

    UserEntity toUserEntity(UpdateRequest updateRequest);

    UserResponse toUserResponse(UserEntity user);

    List<UserResponse> toUserResponses(List<UserEntity> userEntityList);

    @Mapping(target = "technology", source = "technologyId")
    UserDetailsResponse toUserDetail(UserEntity user);
}
