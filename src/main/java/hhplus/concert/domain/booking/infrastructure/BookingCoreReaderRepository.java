package hhplus.concert.domain.booking.infrastructure;

import hhplus.concert.domain.booking.models.Booking;
import hhplus.concert.domain.booking.repositories.BookingReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class BookingCoreReaderRepository implements BookingReaderRepository {

    private final BookingJpaRepository bookingJpaRepository;

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingJpaRepository.findBookingsByUserId(userId);

    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingJpaRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Booking> getBookingsBySeatIds(List<Long> ids) {
        return bookingJpaRepository.findBookingsBySeatIds(ids);
    }
}
