package com.recruitment.mapper;

import com.recruitment.dto.response.AdminLoginResponse;
import com.recruitment.entity.AdminEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T10:50:02+0400",
    comments = "version: 1.4.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminLoginResponse toLoginResponse(AdminEntity adminEntity) {
        if ( adminEntity == null ) {
            return null;
        }

        AdminLoginResponse adminLoginResponse = new AdminLoginResponse();

        adminLoginResponse.setId( adminEntity.getId() );
        adminLoginResponse.setName( adminEntity.getName() );
        adminLoginResponse.setSurname( adminEntity.getSurname() );
        adminLoginResponse.setUserName( adminEntity.getUserName() );

        return adminLoginResponse;
    }
}
