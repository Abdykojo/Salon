package kg.m.salon.service.impl;

import kg.m.salon.Maper.WorkDayMapper;
import kg.m.salon.enums.Days;
import kg.m.salon.models.dto.WorkDayDto;
import kg.m.salon.models.entity.Master;
import kg.m.salon.models.entity.WorkDay;
import kg.m.salon.repositories.WorkDayRep;
import kg.m.salon.request.ScheduleRequest;
import kg.m.salon.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class WorkDayServiceImpl implements WorkDayService {
    @Autowired
    WorkDayRep rep;

    WorkDayMapper mapper= WorkDayMapper.INSTANCE;
    @Override
    public WorkDayDto save(WorkDayDto workDayDto) {
        return mapper.toDto(rep.save(mapper.toEntity(workDayDto)));
    }

    @Override
    public WorkDayDto findById(Long id) {
        return WorkDayMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Клиент не найден")));
    }

    @Override
    public List<WorkDayDto> findAll() {
        return WorkDayMapper.INSTANCE.toDtos(rep.findAll());
    }


    @Override
    public String createSchedule(ScheduleRequest scheduleRequest) {
        WorkDayDto dto=new WorkDayDto();
        dto.setStartDate(scheduleRequest.getStartDate());
        dto.setEndDate(scheduleRequest.getEndDate());
        dto.setDays(scheduleRequest.getDays());
        save(dto);
        return "Success";
    }

    @Override
    public List<WorkDayDto> getList() {
        List<WorkDayDto> dayDtos=findAll();
        System.out.println(dayDtos);
        return dayDtos;
    }

    @Override
    public String setSchedule(Long workDayId, Long masterId) {
        int result=rep.create(workDayId,masterId);
        System.out.println(result);
        return "Success";
    }

    @Override
    public List<WorkDayDto> findByMaster(Long masterId) {
        List<WorkDay> ddays=rep.findbyMaster(masterId);
        return mapper.toDtos(ddays);
    }
}
