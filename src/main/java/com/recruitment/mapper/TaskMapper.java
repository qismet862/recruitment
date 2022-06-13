package com.recruitment.mapper;

import com.recruitment.dto.response.TaskResponse;
import com.recruitment.entity.TaskEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    List<TaskResponse> toResponse(List<TaskEntity> entities);
}
