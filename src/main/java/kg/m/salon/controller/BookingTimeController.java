package kg.m.salon.controller;

import io.swagger.annotations.Api;
import kg.m.salon.models.dto.BookingTimeDto;
import kg.m.salon.request.BookingRequest;
import kg.m.salon.service.BookingTimeService;
import kg.m.salon.swager.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@Api(tags = Swagger2Config.Booking)
public class BookingTimeController {
    @Autowired
    private BookingTimeService service;

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody BookingTimeDto bookingTimeDto){
        try {
            return ResponseEntity.ok(service.save(bookingTimeDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @PostMapping("create/booking")
    public ResponseEntity<?>save(@RequestBody BookingRequest request){
        try {
            return ResponseEntity.ok(service.createBookingRequest(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @PutMapping ("set/booking")
    public ResponseEntity<?>setBookingRequest(@RequestParam Long workDayId, @RequestParam Long bookingTimeId){
        try {
            return ResponseEntity.ok(service.setBookingRequest(workDayId,bookingTimeId));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
