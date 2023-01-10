package kg.m.salon.service.impl;

import kg.m.salon.Maper.OTPmapper;
import kg.m.salon.enums.OTPstatus;
import kg.m.salon.models.dto.OTPDto;
import kg.m.salon.models.entity.OTP;
import kg.m.salon.repositories.OtpRep;
import kg.m.salon.request.OTPrequest;
import kg.m.salon.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OtpServiceImpl implements OtpService {

    OTPmapper mapper = OTPmapper.INSTANCE;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private OtpRep otpRep;


    //    @Value("${spring.mail.username}")
//    private String username;

    @Override
    public String emailSend(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        OTPDto dto = new OTPDto();
        Random random = new Random();
        dto.setCode((int) (random.nextDouble() * random.nextInt(1000)));
        message.setFrom("Abdykojo@gmail.com");
        message.setTo(to);
        message.setText("не показывайте третьим лицам " + dto.getCode());
        message.setSubject("Salon verification");
        emailSender.send(message);
        dto.setStatus(OTPstatus.ACTIVE);
        dto.setSendDate(new Date());
        //dto.setRetDate(new Date());
        save(dto);
        return ("отправлен код на вашу почту");
    }


    @Override
    public OTPDto save(OTPDto dto) {
        return mapper.toDto(otpRep.save(mapper.toEntity(dto)));
    }

    @Override
    public OTPDto findById(Long id) {
        return null;
    }

    @Override
    public List<OTPDto> findAll() {
        return null;
    }

    @Override
    @Transactional
    public String checkCode(OTPrequest request) {
        OTPDto dto = getByCode(request.getCode());
        OTP otp = otpRep.findByCode(request.getCode()).orElse(null);

        if (checkDate(otp.getSendDate())) {
            dto.setRetDate(new Date());
            dto.setStatus(OTPstatus.BLOCKED);
            otpRep.updateRetDate(dto.getCode());
            otpRep.updatesTATUS(dto.getCode());
            otpRep.save(mapper.toEntity(dto));
            System.out.println(otpRep);
            save(dto);
            System.out.println(otp);
            otpRep.save(otp);
            throw new RuntimeException("Вы записались");
        } else  {
            //otp.get().setStatus(S);
            throw new RuntimeException("Ваше время истекло");
            // }
        }
    }

    private boolean checkDate(Date sendDate) {
        Calendar checkDate = Calendar.getInstance();
        checkDate.setTime(sendDate);
        checkDate.add(Calendar.HOUR, 1);
        return  new Date().before(checkDate.getTime());
    }

    private OTPDto getByCode(int code) {
        return mapper.toDto(otpRep.findByCode(code).orElseThrow(() -> new RuntimeException("Код не найден")));
    }
}