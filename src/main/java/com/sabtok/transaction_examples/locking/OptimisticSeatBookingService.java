package com.sabtok.transaction_examples.locking;

import com.sabtok.transaction_examples.locking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimisticSeatBookingService {

    @Autowired
    private SeatBookingService seatBookingService;

    //t1 booked but not got response "partial failure" or the "two-army problem."

    public void testOptimisticLocking(long seatId) throws InterruptedException {
            Thread t1 = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+ " is attempting to book seat");
                    Seat seat = seatBookingService.bookSeat(seatId);
                    System.out.println(Thread.currentThread().getName()+ " is success fully booked seat with version "+seat.getVersion());
                } catch (Exception e){
                    System.out.println(Thread.currentThread().getName()+" failed "+e.getMessage());
                }
            });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+ " is attempting to book seat");
                Seat seat = seatBookingService.bookSeat(seatId);
                System.out.println(Thread.currentThread().getName()+ " is success fully booked seat with version "+seat.getVersion());
            } catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" failed "+e.getMessage());
            }
        });
        t1.start();
        Thread.sleep(2000);
        t2.start();
        t1.join();
        t2.join();
    }
}
