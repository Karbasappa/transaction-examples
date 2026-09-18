package com.sabtok.transaction_examples.repo;

import com.sabtok.transaction_examples.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
