package com.sabtok.transaction_examples.repo;

import com.sabtok.transaction_examples.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
