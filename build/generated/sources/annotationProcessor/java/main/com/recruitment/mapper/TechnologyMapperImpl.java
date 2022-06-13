package com.recruitment.mapper;

import com.recruitment.dto.response.TechnologyResponse;
import com.recruitment.entity.TechnologyEntity;
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
public class TechnologyMapperImpl implements TechnologyMapper {

    @Override
    public List<TechnologyResponse> toTechnologyResponse(List<TechnologyEntity> technologyEntity) {
        if ( technologyEntity == null ) {
            return null;
        }

        List<TechnologyResponse> list = new ArrayList<TechnologyResponse>( technologyEntity.size() );
        for ( TechnologyEntity technologyEntity1 : technologyEntity ) {
            list.add( technologyEntityToTechnologyResponse( technologyEntity1 ) );
        }

        return list;
    }

    protected TechnologyResponse technologyEntityToTechnologyResponse(TechnologyEntity technologyEntity) {
        if ( technologyEntity == null ) {
            return null;
        }

        TechnologyResponse technologyResponse = new TechnologyResponse();

        technologyResponse.setId( technologyEntity.getId() );
        technologyResponse.setName( technologyEntity.getName() );

        return technologyResponse;
    }
}
