package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.WorkDayDto;
import kg.m.salon.models.entity.WorkDay;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T09:30:04+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class WorkDayMapperImpl implements WorkDayMapper {

    @Override
    public WorkDay toEntity(WorkDayDto d) {
        if ( d == null ) {
            return null;
        }

        WorkDay workDay = new WorkDay();

        workDay.setId( d.getId() );
        workDay.setStartDate( d.getStartDate() );
        workDay.setEndDate( d.getEndDate() );
        workDay.setDays( d.getDays() );

        return workDay;
    }

    @Override
    public WorkDayDto toDto(WorkDay e) {
        if ( e == null ) {
            return null;
        }

        WorkDayDto workDayDto = new WorkDayDto();

        workDayDto.setId( e.getId() );
        workDayDto.setStartDate( e.getStartDate() );
        workDayDto.setEndDate( e.getEndDate() );
        workDayDto.setDays( e.getDays() );

        return workDayDto;
    }

    @Override
    public List<WorkDay> toEntities(List<WorkDayDto> d) {
        if ( d == null ) {
            return null;
        }

        List<WorkDay> list = new ArrayList<WorkDay>( d.size() );
        for ( WorkDayDto workDayDto : d ) {
            list.add( toEntity( workDayDto ) );
        }

        return list;
    }

    @Override
    public List<WorkDayDto> toDtos(List<WorkDay> e) {
        if ( e == null ) {
            return null;
        }

        List<WorkDayDto> list = new ArrayList<WorkDayDto>( e.size() );
        for ( WorkDay workDay : e ) {
            list.add( toDto( workDay ) );
        }

        return list;
    }
}
