package com.c0620k1.demo.repository;

import com.c0620k1.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
