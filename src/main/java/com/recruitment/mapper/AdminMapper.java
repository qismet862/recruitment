package com.recruitment.mapper;

import com.recruitment.dto.response.AdminLoginResponse;
import com.recruitment.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AdminMapper {
    AdminLoginResponse toLoginResponse(AdminEntity adminEntity);
}
