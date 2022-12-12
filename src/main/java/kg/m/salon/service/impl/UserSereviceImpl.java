package kg.m.salon.service.impl;

import kg.m.salon.Maper.UserMapper;
import kg.m.salon.models.dto.UserDto;
import kg.m.salon.models.entity.User;
import kg.m.salon.repositories.UserRep;
import kg.m.salon.request.AuthRequest;
import kg.m.salon.response.Response;
import kg.m.salon.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserSereviceImpl implements UserSerevice {

    @Autowired
    UserRep rep;
    UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public UserDto save(UserDto userDto) {
        return mapper.toDto(rep.save(mapper.toEntity(userDto)));
    }

    @Override
    public UserDto findById(Long id) {
        return UserMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Клиент не найден")));
    }

    @Override
    public List<UserDto> findAll() {

        return UserMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Temporal(TemporalType.TIME)
    @Override
    @Transactional
    public Response auth(AuthRequest authRequest) {
        UserDto userDto = getByLogin(authRequest.getLogin());
        Optional<User> us = rep.findByLogin(authRequest.getLogin());
            if (!us.get().getPassword().equals(authRequest.getPassword())){
                throw new RuntimeException("Не правльный пароль");
            }
        Response response = new Response("Вы успешно вошли", authRequest.getLogin());
        return response;
    }
    @Override
    public UserDto getByLogin(String login){
        return mapper.toDto(rep.findByLogin(login).orElseThrow(()->new RuntimeException("Пользователь не найден")));

    }
}
