package com.sabtok.transaction_examples.locking;

import com.sabtok.transaction_examples.locking.entity.Seat;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
