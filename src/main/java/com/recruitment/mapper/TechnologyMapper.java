package com.recruitment.mapper;

import com.recruitment.dto.response.TechnologyResponse;
import com.recruitment.entity.TechnologyEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyMapper {
    List<TechnologyResponse> toTechnologyResponse(List<TechnologyEntity> technologyEntity);
}
