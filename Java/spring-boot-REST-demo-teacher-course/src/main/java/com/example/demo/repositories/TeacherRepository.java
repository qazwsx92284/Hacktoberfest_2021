package com.example.demo.repositories;

import com.example.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository <Teacher, Long> {
}
