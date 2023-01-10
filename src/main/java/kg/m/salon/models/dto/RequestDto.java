package kg.m.salon.models.dto;

import kg.m.salon.models.entity.Master;
import kg.m.salon.models.entity.User;
import kg.m.salon.models.entity.WorkDay;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class RequestDto {
    Date startDate;
    Date enddate;
    User userId;
    List<WorkDay> workDayList;
}
