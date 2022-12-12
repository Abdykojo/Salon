package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.MasterDto;
import kg.m.salon.models.dto.SalonDto;
import kg.m.salon.models.entity.Master;
import kg.m.salon.models.entity.Salon;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T09:30:40+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class MasterMapperImpl implements MasterMapper {

    @Override
    public Master toEntity(MasterDto d) {
        if ( d == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( d.getId() );
        master.setName( d.getName() );
        master.setExperience( d.getExperience() );
        master.setSalonId( salonDtoToSalon( d.getSalonId() ) );

        return master;
    }

    @Override
    public MasterDto toDto(Master e) {
        if ( e == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( e.getId() );
        masterDto.setName( e.getName() );
        masterDto.setExperience( e.getExperience() );
        masterDto.setSalonId( salonToSalonDto( e.getSalonId() ) );

        return masterDto;
    }

    @Override
    public List<Master> toEntities(List<MasterDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Master> list = new ArrayList<Master>( d.size() );
        for ( MasterDto masterDto : d ) {
            list.add( toEntity( masterDto ) );
        }

        return list;
    }

    @Override
    public List<MasterDto> toDtos(List<Master> e) {
        if ( e == null ) {
            return null;
        }

        List<MasterDto> list = new ArrayList<MasterDto>( e.size() );
        for ( Master master : e ) {
            list.add( toDto( master ) );
        }

        return list;
    }

    protected Salon salonDtoToSalon(SalonDto salonDto) {
        if ( salonDto == null ) {
            return null;
        }

        Salon salon = new Salon();

        salon.setId( salonDto.getId() );
        salon.setName( salonDto.getName() );
        salon.setAddress( salonDto.getAddress() );

        return salon;
    }

    protected SalonDto salonToSalonDto(Salon salon) {
        if ( salon == null ) {
            return null;
        }

        SalonDto salonDto = new SalonDto();

        salonDto.setId( salon.getId() );
        salonDto.setName( salon.getName() );
        salonDto.setAddress( salon.getAddress() );

        return salonDto;
    }
}
