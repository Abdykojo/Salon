package kg.m.salon.controller;

import kg.m.salon.request.OTPrequest;
import kg.m.salon.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpController {
    @Autowired
     OtpService otpService;

    @GetMapping("/send")
    public ResponseEntity<?> sendCode(@RequestParam String to){
        try {
            return ResponseEntity.ok(otpService.emailSend(to));
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping ("/get")
    public ResponseEntity<?> verification(@RequestBody OTPrequest request){
        try {
            return ResponseEntity.ok(otpService.checkCode(request));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
