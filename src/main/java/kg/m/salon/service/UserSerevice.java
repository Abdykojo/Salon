package kg.m.salon.service;

import kg.m.salon.models.dto.UserDto;
import kg.m.salon.request.AuthRequest;
import kg.m.salon.response.Response;

public interface UserSerevice extends BaseService<UserDto>{
    Response auth(AuthRequest authRequest);
    UserDto getByLogin(String login);
}
