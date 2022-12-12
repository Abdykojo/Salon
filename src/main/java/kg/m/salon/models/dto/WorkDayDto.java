package kg.m.salon.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.m.salon.enums.Days;
import kg.m.salon.models.entity.Master;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class WorkDayDto {
    Long id;
    Date startDate;
    Date endDate;
    @JsonIgnore
    List<Master>masterList;
    Days days;
}
