package com.sabtok.transaction_examples.controller;

import com.sabtok.transaction_examples.locking.OptimisticSeatBookingService;
import com.sabtok.transaction_examples.locking.PesimisticSeatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class SeatBookingController {

    @Autowired
    OptimisticSeatBookingService seatBookingService;

    @Autowired
    PesimisticSeatBookingService pesimisticSeatBookingService;

    @GetMapping("/optimistic/{seatId}")
    public String testOptimistic(@PathVariable Long seatId) throws InterruptedException {
        seatBookingService.testOptimisticLocking(seatId);
        return "Optimistic locking test started! check logs for result";
    }

    @GetMapping("/pesimistic/{seatId}")
    public String testPesimistic(@PathVariable Long seatId) throws InterruptedException {
        pesimisticSeatBookingService.testPesimisticSeatBookingService(seatId);
        return "Optimistic locking test started! check logs for result";
    }
}
