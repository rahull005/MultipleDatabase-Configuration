package com.database.MultipleDatabaseConfig.mysql.repository;

import com.database.MultipleDatabaseConfig.mysql.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
