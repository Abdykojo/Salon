package kg.m.salon.Maper;

import kg.m.salon.models.dto.OTPDto;
import kg.m.salon.models.entity.OTP;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OTPmapper extends BaseMapper<OTP, OTPDto>{
    OTPmapper INSTANCE= Mappers.getMapper(OTPmapper.class);

}
