package kg.m.salon.request;

import kg.m.salon.enums.Days;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleRequest {
    Date startDate;
    Date endDate;
    Days days;

}
