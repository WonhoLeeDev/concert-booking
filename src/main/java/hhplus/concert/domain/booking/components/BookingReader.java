package hhplus.concert.domain.booking.components;

import hhplus.concert.domain.booking.models.Booking;
import hhplus.concert.domain.booking.repositories.BookingReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingReader {

    private final BookingReaderRepository bookingReaderRepository;

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingReaderRepository.getBookingsByUserId(userId);
    }

    public Booking getBookingById(Long id) {
        return bookingReaderRepository.getBookingById(id);
    }

    public List<Booking> getBookingsBySeatIds(List<Long> seatIds) {
        return bookingReaderRepository.getBookingsBySeatIds(seatIds);
    }
}
