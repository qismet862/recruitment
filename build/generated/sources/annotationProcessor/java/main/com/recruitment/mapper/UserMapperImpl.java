package com.recruitment.mapper;

import com.recruitment.dto.request.UpdateRequest;
import com.recruitment.dto.request.UserRequest;
import com.recruitment.dto.response.AddressResponse;
import com.recruitment.dto.response.TaskResponse;
import com.recruitment.dto.response.UserDetailsResponse;
import com.recruitment.dto.response.UserLoginResponse;
import com.recruitment.dto.response.UserResponse;
import com.recruitment.entity.AddressEntity;
import com.recruitment.entity.TaskEntity;
import com.recruitment.entity.TechnologyEntity;
import com.recruitment.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T10:50:02+0400",
    comments = "version: 1.4.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName( userRequest.getName() );
        userEntity.setSurname( userRequest.getSurname() );
        userEntity.setMobile( userRequest.getMobile() );
        userEntity.setEmail( userRequest.getEmail() );
        userEntity.setGithub( userRequest.getGithub() );
        userEntity.setUserName( userRequest.getUserName() );
        userEntity.setPassword( userRequest.getPassword() );
        userEntity.setEng( userRequest.getEng() );
        userEntity.setAz( userRequest.getAz() );
        userEntity.setTur( userRequest.getTur() );
        userEntity.setRus( userRequest.getRus() );

        return userEntity;
    }

    @Override
    public UserLoginResponse toLoginResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        List<TechnologyEntity> list = userEntity.getTechnologyId();
        if ( list != null ) {
            userLoginResponse.setTechnology( new ArrayList<TechnologyEntity>( list ) );
        }
        userLoginResponse.setId( userEntity.getId() );
        userLoginResponse.setName( userEntity.getName() );
        userLoginResponse.setSurname( userEntity.getSurname() );
        userLoginResponse.setMobile( userEntity.getMobile() );
        userLoginResponse.setEmail( userEntity.getEmail() );
        userLoginResponse.setGithub( userEntity.getGithub() );
        userLoginResponse.setAddress( addressEntityToAddressResponse( userEntity.getAddress() ) );
        userLoginResponse.setCvUrl( userEntity.getCvUrl() );
        userLoginResponse.setUserName( userEntity.getUserName() );
        userLoginResponse.setEng( userEntity.getEng() );
        userLoginResponse.setAz( userEntity.getAz() );
        userLoginResponse.setTur( userEntity.getTur() );
        userLoginResponse.setRus( userEntity.getRus() );

        return userLoginResponse;
    }

    @Override
    public UserEntity toUserEntity(UpdateRequest updateRequest) {
        if ( updateRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( updateRequest.getId() );
        userEntity.setName( updateRequest.getName() );
        userEntity.setSurname( updateRequest.getSurname() );
        userEntity.setMobile( updateRequest.getMobile() );
        userEntity.setEmail( updateRequest.getEmail() );
        userEntity.setGithub( updateRequest.getGithub() );
        userEntity.setUserName( updateRequest.getUserName() );
        userEntity.setEng( updateRequest.getEng() );
        userEntity.setAz( updateRequest.getAz() );
        userEntity.setTur( updateRequest.getTur() );
        userEntity.setRus( updateRequest.getRus() );

        return userEntity;
    }

    @Override
    public UserResponse toUserResponse(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setName( user.getName() );
        userResponse.setSurname( user.getSurname() );
        userResponse.setMobile( user.getMobile() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setUserName( user.getUserName() );

        return userResponse;
    }

    @Override
    public List<UserResponse> toUserResponses(List<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( toUserResponse( userEntity ) );
        }

        return list;
    }

    @Override
    public UserDetailsResponse toUserDetail(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();

        List<TechnologyEntity> list = user.getTechnologyId();
        if ( list != null ) {
            userDetailsResponse.setTechnology( new ArrayList<TechnologyEntity>( list ) );
        }
        userDetailsResponse.setId( user.getId() );
        userDetailsResponse.setName( user.getName() );
        userDetailsResponse.setSurname( user.getSurname() );
        userDetailsResponse.setMobile( user.getMobile() );
        userDetailsResponse.setEmail( user.getEmail() );
        userDetailsResponse.setGithub( user.getGithub() );
        userDetailsResponse.setCvUrl( user.getCvUrl() );
        userDetailsResponse.setUserName( user.getUserName() );
        userDetailsResponse.setEng( user.getEng() );
        userDetailsResponse.setAz( user.getAz() );
        userDetailsResponse.setTur( user.getTur() );
        userDetailsResponse.setRus( user.getRus() );
        userDetailsResponse.setTask( taskEntityListToTaskResponseList( user.getTask() ) );
        userDetailsResponse.setAddress( addressEntityToAddressResponse( user.getAddress() ) );

        return userDetailsResponse;
    }

    protected AddressResponse addressEntityToAddressResponse(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setCity( addressEntity.getCity() );
        addressResponse.setZipCode( addressEntity.getZipCode() );

        return addressResponse;
    }

    protected TaskResponse taskEntityToTaskResponse(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId( taskEntity.getId() );
        taskResponse.setTaskUrl( taskEntity.getTaskUrl() );
        taskResponse.setAnswerUrl( taskEntity.getAnswerUrl() );

        return taskResponse;
    }

    protected List<TaskResponse> taskEntityListToTaskResponseList(List<TaskEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskResponse> list1 = new ArrayList<TaskResponse>( list.size() );
        for ( TaskEntity taskEntity : list ) {
            list1.add( taskEntityToTaskResponse( taskEntity ) );
        }

        return list1;
    }
}
