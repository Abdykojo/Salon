package kg.m.salon.models.entity;

import kg.m.salon.enums.Days;
import kg.m.salon.models.entity.Master;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_work_day",uniqueConstraints = {@UniqueConstraint(columnNames = {"end_date", "days", "start_date"})})

public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.TIME)
    @Column(name = "start_date")
    Date startDate;
    @Temporal(TemporalType.TIME)
    @Column(name = "end_date")
    Date endDate;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_work_day_master",
            joinColumns = {@JoinColumn(name = "work_day_id")},
            inverseJoinColumns = {@JoinColumn(name = "master_id")},
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"master_id"})})
    List<Master>masterId;
    @Column(name = "days")

    Days days;

}
