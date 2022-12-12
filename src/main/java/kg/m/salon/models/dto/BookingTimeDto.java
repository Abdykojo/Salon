package kg.m.salon.models.dto;

import kg.m.salon.enums.BookingStatus;
import kg.m.salon.models.entity.User;
import kg.m.salon.models.entity.WorkDay;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookingTimeDto {
    Long id;
    Date startDate;
    Date endDate;
    Date addDate;
    Date updateDate;
    BookingStatus status;
    List<WorkDay>workDayId;
    User userId;
}
