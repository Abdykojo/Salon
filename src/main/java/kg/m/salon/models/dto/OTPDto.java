package kg.m.salon.models.dto;

import kg.m.salon.enums.OTPstatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OTPDto {
    Long id;
    int code;
    Date sendDate;

    Date retDate;
    OTPstatus status;
}
