package com.database.MultipleDatabaseConfig.oracle.repository;

import com.database.MultipleDatabaseConfig.oracle.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Integer> {
}
