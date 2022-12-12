package kg.m.salon.service.impl;

import kg.m.salon.Maper.BookingTimeMapper;
import kg.m.salon.models.dto.BookingTimeDto;
import kg.m.salon.models.entity.BookingTime;
import kg.m.salon.repositories.BookingTimeRep;
import kg.m.salon.request.BookingRequest;
import kg.m.salon.response.Response;
import kg.m.salon.service.BookingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingTimeServiceImpl implements BookingTimeService {
    @Autowired
    BookingTimeRep rep;

    BookingTime bookingTime;

    BookingTimeMapper mapper = BookingTimeMapper.INSTANCE;


    @Override
    public BookingTimeDto save(BookingTimeDto bookingTimeDto) {
        return mapper.toDto(rep.save(mapper.toEntity(bookingTimeDto)));
    }

    @Override
    public BookingTimeDto findById(Long id) {
        return BookingTimeMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<BookingTimeDto> findAll() {
        return BookingTimeMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public Response createBookingRequest(BookingRequest request) {
        Optional<BookingTime> bDate = rep.findByStartDate(request.getStartDate());
        if (bDate.isPresent()) {
            throw new RuntimeException("Такая запись уже существует");
        } else {
            BookingTimeDto dto = new BookingTimeDto();
            dto.setStartDate(request.getStartDate());
            dto.setEndDate(request.getEndDate());
            dto.setAddDate(request.getAddDate());
            dto.setUpdateDate(request.getUpdateDate());
            dto.setStatus(request.getStatus());
            dto.setWorkDayId(request.getWorkDayId());
            dto.setUserId(request.getUserId());
            save(dto);
            Response response = new Response("Ваша запись сохранена", request.getStartDate());
            return response;
        }

    }

    @Override
    public BookingTimeDto getByStartDate(Date startDate) {
        return null;// mapper.toDto(rep.findByStartDate(startDate).orElseThrow(()->new RuntimeException("11")));
    }

    @Override
    public String setBookingRequest(Long workDayId, Long bookingTimeId) {
        int result = rep.create(workDayId, bookingTimeId);
        System.out.println(result);
        return "Success";
    }
}
