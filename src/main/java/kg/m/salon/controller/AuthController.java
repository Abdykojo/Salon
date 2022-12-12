package kg.m.salon.controller;

import io.swagger.annotations.ApiOperation;
import kg.m.salon.request.AuthRequest;
import kg.m.salon.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@ApiOperation("Метод авторизации")
public class AuthController {
    @Autowired
    protected UserSerevice userSerevice;
    @PostMapping
    public ResponseEntity<?>auth(@RequestBody AuthRequest authRequest){
        try {
            return ResponseEntity.ok(userSerevice.auth(authRequest));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
