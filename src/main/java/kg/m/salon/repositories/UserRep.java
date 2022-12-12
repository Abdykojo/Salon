package kg.m.salon.repositories;

import kg.m.salon.models.entity.User;
import kg.m.salon.request.AuthRequest;
import kg.m.salon.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends JpaRepository<User,Long> {
    Optional<User> findByLogin(String login);
}
