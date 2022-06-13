package com.recruitment.mapper;

import com.recruitment.dto.response.NotificationResponse;
import com.recruitment.entity.NotificationEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NotificationMapper {
    List<NotificationResponse> toResponse(List<NotificationEntity> notificationEntities);
}
