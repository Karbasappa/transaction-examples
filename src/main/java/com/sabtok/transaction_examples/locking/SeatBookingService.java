package com.sabtok.transaction_examples.locking;

import com.sabtok.transaction_examples.locking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatBookingService {

    @Autowired
    SeatRepository seatRepository;

    @Transactional
    public void bookSeatWithPessimistic(Long seatNo){
        System.out.println(Thread.currentThread().getName()+" is attempting to fetch seat");
        Seat seat = seatRepository.findAndLock(seatNo);
        System.out.println(Thread.currentThread().getName()+" acquired lock");
        if (seat.isBooked()){
            throw new RuntimeException("Seat already booked..!");
        }

        seat.setBooked(true);
        seatRepository.save(seat);
        System.out.println(Thread.currentThread().getName()+" successfully booked the seat with id "+seatNo);
    }

    @Transactional
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
