package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.SalonDto;
import kg.m.salon.models.entity.Salon;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T22:56:04+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class SalonMapperImpl implements SalonMapper {

    @Override
    public Salon toEntity(SalonDto d) {
        if ( d == null ) {
            return null;
        }

        Salon salon = new Salon();

        return salon;
    }

    @Override
    public SalonDto toDto(Salon e) {
        if ( e == null ) {
            return null;
        }

        SalonDto salonDto = new SalonDto();

        return salonDto;
    }

    @Override
    public List<Salon> toEntities(List<SalonDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Salon> list = new ArrayList<Salon>( d.size() );
        for ( SalonDto salonDto : d ) {
            list.add( toEntity( salonDto ) );
        }

        return list;
    }

    @Override
    public List<SalonDto> toDtos(List<Salon> e) {
        if ( e == null ) {
            return null;
        }

        List<SalonDto> list = new ArrayList<SalonDto>( e.size() );
        for ( Salon salon : e ) {
            list.add( toDto( salon ) );
        }

        return list;
    }
}
