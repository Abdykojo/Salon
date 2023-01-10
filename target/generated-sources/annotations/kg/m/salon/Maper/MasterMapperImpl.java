package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.MasterDto;
import kg.m.salon.models.entity.Master;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T22:56:04+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class MasterMapperImpl implements MasterMapper {

    @Override
    public Master toEntity(MasterDto d) {
        if ( d == null ) {
            return null;
        }

        Master master = new Master();

        return master;
    }

    @Override
    public MasterDto toDto(Master e) {
        if ( e == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

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
}
