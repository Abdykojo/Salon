package kg.m.salon.controller;

import io.swagger.annotations.Api;
import kg.m.salon.models.dto.UserDto;
import kg.m.salon.request.AuthRequest;
import kg.m.salon.service.UserSerevice;
import kg.m.salon.swager.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@Api(tags = Swagger2Config.Client)

public class UserControler {
    @Autowired
    private UserSerevice serevice;

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(serevice.save(userDto));

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);

        }

    }

}
