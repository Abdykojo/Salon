package kg.m.salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.m.salon.enums.Days;
import kg.m.salon.models.dto.WorkDayDto;
import kg.m.salon.request.ScheduleRequest;
import kg.m.salon.service.WorkDayService;
import kg.m.salon.swager.Swagger2Config;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/day")
@Api(tags = Swagger2Config.Work)
public class WorkDayController {
    @Autowired
    private WorkDayService service;

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody WorkDayDto workDayDto){
        try {
            return ResponseEntity.ok(service.save(workDayDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PostMapping("create/schedule")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequest request){
        try {
            return ResponseEntity.ok(service.createSchedule(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PostMapping("set/master/schedule")
    public ResponseEntity<?> setSchedule(@RequestParam Long workDayId,@RequestParam Long masterId){
        try {
            return ResponseEntity.ok(service.setSchedule(workDayId,masterId));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @GetMapping("/get")
    @ApiOperation("Вывод графика мастера")
    public ResponseEntity<?> save(@RequestParam Long masterId) {
        try {
            return ResponseEntity.ok(service.findByMaster(masterId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
