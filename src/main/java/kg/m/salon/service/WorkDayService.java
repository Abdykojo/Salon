package kg.m.salon.service;

import kg.m.salon.enums.Days;
import kg.m.salon.models.dto.MasterDto;
import kg.m.salon.models.dto.WorkDayDto;
import kg.m.salon.models.entity.Salon;
import kg.m.salon.request.ScheduleRequest;

import java.util.Date;
import java.util.List;

public interface WorkDayService extends BaseService<WorkDayDto>{
    String createSchedule(ScheduleRequest scheduleRequest);
    List<WorkDayDto> getList();

    String setSchedule(Long workDayId, Long masterId);
    List<WorkDayDto> findByMaster(Long masterId);
}
