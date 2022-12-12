package kg.m.salon.repositories;

import kg.m.salon.models.dto.BookingTimeDto;
import kg.m.salon.models.entity.BookingTime;
import kg.m.salon.request.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface BookingTimeRep extends JpaRepository<BookingTime,Long> {

   // Optional<BookingTime> findByStartDate(BookingTime bookingTime);
   @Modifying
   @Transactional
   @Query(value = "insert into tb_bwork_day_booking(work_day_id,bookingTimeId) VALUES(?1,?2)",nativeQuery = true)
   int create(Long workDayId,Long bookingTimeId);
    Optional<BookingTime> findByStartDate(Date startDate);
}
