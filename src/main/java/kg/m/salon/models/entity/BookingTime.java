package kg.m.salon.models.entity;

import kg.m.salon.enums.BookingStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_booking_time")
public class BookingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date startDate;
    Date endDate;
    Date addDate;
    Date updateDate;
    BookingStatus status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "work_day_booking",
            joinColumns = @JoinColumn(name="booking_id"),
            inverseJoinColumns = @JoinColumn(name = "work_day_id")
    )
    List<WorkDay>workDayId;

    @ManyToOne
    @JoinColumn(name="tb_user_id")
    User userId;

}
