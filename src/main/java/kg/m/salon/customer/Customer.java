//package kg.m.salon.customer;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "customers")
//public class Customer {
//}
//
//    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
//
//    @Column(name = "one_time_password")
//    private String oneTimePassword;
//
//    @Column(name = "otp_requested_time")
//    private Date otpRequestedTime;
//
//
//    public boolean isOTPRequired() {
//        if (this.getOneTimePassword() == null) {
//            return false;
//        }
//
//        long currentTimeInMillis = System.currentTimeMillis();
//        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
//
//        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
//            // OTP expires
//            return false;
//        }
//
//        return true;
//    }
//
//
//    // other fields, getters and setters are not shown
//}