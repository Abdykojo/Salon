package kg.m.salon.models.entity;

import kg.m.salon.enums.OTPstatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "otp")
@Getter
@Setter
@ToString
public class OTP{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     Long id;
    @Column(name = "code")
    int code;
    @Column(name = "send_date")
    Date sendDate;

    @Column(name = "ret_date")
    Date retDate;
    @Column(name = "status")
    OTPstatus status;


@PreUpdate
    protected void onUpdate(){
    retDate=new Date();
    }

}
