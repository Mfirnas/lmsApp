package com.lms.app.com.lms.app.repo;

import com.lms.app.com.lms.app.model.students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepo extends JpaRepository<students,Integer> {
}
