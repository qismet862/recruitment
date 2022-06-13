package com.recruitment.mapper;

import com.recruitment.dto.response.TaskResponse;
import com.recruitment.entity.TaskEntity;
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
public class TaskMapperImpl implements TaskMapper {

    @Override
    public List<TaskResponse> toResponse(List<TaskEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TaskResponse> list = new ArrayList<TaskResponse>( entities.size() );
        for ( TaskEntity taskEntity : entities ) {
            list.add( taskEntityToTaskResponse( taskEntity ) );
        }

        return list;
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
}
