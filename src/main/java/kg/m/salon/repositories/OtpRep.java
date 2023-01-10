package kg.m.salon.repositories;

import kg.m.salon.enums.OTPstatus;
import kg.m.salon.models.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OtpRep extends JpaRepository<OTP, Long> {
    Optional<OTP> findByCode(int code);

    @Modifying
    @Query("update OTP set status=1 where code=:code")
    void updatesTATUS (int code);

    @Modifying
    @Query("UPDATE OTP SET retDate=NOW() where code=:code")
    void updateRetDate (int code);


}
