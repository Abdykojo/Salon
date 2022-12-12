package kg.m.salon.request;

import kg.m.salon.enums.BookingStatus;
import kg.m.salon.models.entity.User;
import kg.m.salon.models.entity.WorkDay;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    Date startDate;
    Date endDate;
    Date addDate;
    Date updateDate;
    BookingStatus status;
    List<WorkDay> workDayId;
    User userId;
}
