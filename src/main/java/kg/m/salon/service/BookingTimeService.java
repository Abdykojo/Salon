package kg.m.salon.service;

import kg.m.salon.models.dto.BookingTimeDto;
import kg.m.salon.models.dto.WorkDayDto;
import kg.m.salon.request.BookingRequest;
import kg.m.salon.response.Response;

import java.util.Date;
import java.util.List;

public interface BookingTimeService extends BaseService<BookingTimeDto>{
    Response createBookingRequest(BookingRequest request);
   // List<BookingTimeDto> getList();

    BookingTimeDto getByStartDate(Date startDate);

    String setBookingRequest(Long workDayId, Long bookingTimeId);
}
