package kg.m.salon.Maper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.m.salon.models.dto.UserDto;
import kg.m.salon.models.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T22:56:04+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto d) {
        if ( d == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserDto toDto(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public List<User> toEntities(List<UserDto> d) {
        if ( d == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( d.size() );
        for ( UserDto userDto : d ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDtos(List<User> e) {
        if ( e == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( e.size() );
        for ( User user : e ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
