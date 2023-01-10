package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.OTPDto;
import kg.m.salon.models.entity.OTP;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T22:56:50+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class OTPmapperImpl implements OTPmapper {

    @Override
    public OTP toEntity(OTPDto d) {
        if ( d == null ) {
            return null;
        }

        OTP oTP = new OTP();

        oTP.setId( d.getId() );
        oTP.setCode( d.getCode() );
        oTP.setSendDate( d.getSendDate() );
        oTP.setRetDate( d.getRetDate() );
        oTP.setStatus( d.getStatus() );

        return oTP;
    }

    @Override
    public OTPDto toDto(OTP e) {
        if ( e == null ) {
            return null;
        }

        OTPDto oTPDto = new OTPDto();

        oTPDto.setId( e.getId() );
        oTPDto.setCode( e.getCode() );
        oTPDto.setSendDate( e.getSendDate() );
        oTPDto.setRetDate( e.getRetDate() );
        oTPDto.setStatus( e.getStatus() );

        return oTPDto;
    }

    @Override
    public List<OTP> toEntities(List<OTPDto> d) {
        if ( d == null ) {
            return null;
        }

        List<OTP> list = new ArrayList<OTP>( d.size() );
        for ( OTPDto oTPDto : d ) {
            list.add( toEntity( oTPDto ) );
        }

        return list;
    }

    @Override
    public List<OTPDto> toDtos(List<OTP> e) {
        if ( e == null ) {
            return null;
        }

        List<OTPDto> list = new ArrayList<OTPDto>( e.size() );
        for ( OTP oTP : e ) {
            list.add( toDto( oTP ) );
        }

        return list;
    }
}
