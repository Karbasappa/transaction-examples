package com.sabtok.transaction_examples.locking;

import com.sabtok.transaction_examples.locking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatBookingService {

    @Autowired
    SeatRepository seatRepository;

    public Seat bookSeat(Long seatNo){
        Seat seat = seatRepository.findById(seatNo)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        System.out.println(Thread.currentThread().getName()+" fetched seat with version "+seat.getVersion());

        if (seat.isBooked()){
            throw new RuntimeException("Seat already booked..!");
        }

        seat.setBooked(true);
        return seatRepository.save(seat);
    }
}
