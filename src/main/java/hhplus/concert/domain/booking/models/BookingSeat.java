package hhplus.concert.domain.booking.models;

import hhplus.concert.domain.concert.models.Seat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "booking_seat")
public class BookingSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_seat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Builder
    private BookingSeat(Long id, Booking booking, Seat seat) {
        this.id = id;
        this.booking = booking;
        this.seat = seat;
    }

    public static BookingSeat buildBookingSeat(Booking booking, Seat seat) {
        return builder()
                .booking(booking)
                .seat(seat)
                .build();
    }

    public static List<BookingSeat> createBookingSeats(List<Seat> seats, Booking booking) {
        return seats.stream()
                .map(s -> BookingSeat.buildBookingSeat(booking, s))
                .collect(Collectors.toList());
    }
}
