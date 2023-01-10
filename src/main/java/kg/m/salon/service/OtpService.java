package kg.m.salon.service;

import kg.m.salon.models.dto.OTPDto;
import kg.m.salon.request.OTPrequest;

public interface OtpService extends BaseService<OTPDto>{
    String emailSend(String to);
    String checkCode(OTPrequest request);
}
