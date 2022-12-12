package kg.m.salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.m.salon.models.dto.MasterDto;
import kg.m.salon.service.MasterService;
import kg.m.salon.swager.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mas")
@Api(tags = Swagger2Config.Master)

public class MasterController {
    @Autowired
    private MasterService masterService;

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody MasterDto masterDto){
        try {
            return ResponseEntity.ok(masterService.save(masterDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @GetMapping("/find/by/salon")
    @ApiOperation("Вывод списка мастеров по салону")
    public ResponseEntity<?>save(@RequestParam(name="salon_id")Long id){
        try {
            return ResponseEntity.ok(masterService.findBySalon(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
}