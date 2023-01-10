package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.BookingTimeDto;
import kg.m.salon.models.entity.BookingTime;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T22:56:04+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class BookingTimeMapperImpl implements BookingTimeMapper {

    @Override
    public BookingTime toEntity(BookingTimeDto d) {
        if ( d == null ) {
            return null;
        }

        BookingTime bookingTime = new BookingTime();

        return bookingTime;
    }

    @Override
    public BookingTimeDto toDto(BookingTime e) {
        if ( e == null ) {
            return null;
        }

        BookingTimeDto bookingTimeDto = new BookingTimeDto();

        return bookingTimeDto;
    }

    @Override
    public List<BookingTime> toEntities(List<BookingTimeDto> d) {
        if ( d == null ) {
            return null;
        }

        List<BookingTime> list = new ArrayList<BookingTime>( d.size() );
        for ( BookingTimeDto bookingTimeDto : d ) {
            list.add( toEntity( bookingTimeDto ) );
        }

        return list;
    }

    @Override
    public List<BookingTimeDto> toDtos(List<BookingTime> e) {
        if ( e == null ) {
            return null;
        }

        List<BookingTimeDto> list = new ArrayList<BookingTimeDto>( e.size() );
        for ( BookingTime bookingTime : e ) {
            list.add( toDto( bookingTime ) );
        }

        return list;
    }
}
