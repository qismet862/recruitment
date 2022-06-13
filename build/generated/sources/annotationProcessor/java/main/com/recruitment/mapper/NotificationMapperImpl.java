package com.recruitment.mapper;

import com.recruitment.dto.response.NotificationResponse;
import com.recruitment.entity.NotificationEntity;
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
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public List<NotificationResponse> toResponse(List<NotificationEntity> notificationEntities) {
        if ( notificationEntities == null ) {
            return null;
        }

        List<NotificationResponse> list = new ArrayList<NotificationResponse>( notificationEntities.size() );
        for ( NotificationEntity notificationEntity : notificationEntities ) {
            list.add( notificationEntityToNotificationResponse( notificationEntity ) );
        }

        return list;
    }

    protected NotificationResponse notificationEntityToNotificationResponse(NotificationEntity notificationEntity) {
        if ( notificationEntity == null ) {
            return null;
        }

        NotificationResponse notificationResponse = new NotificationResponse();

        notificationResponse.setNotification( notificationEntity.getNotification() );

        return notificationResponse;
    }
}
