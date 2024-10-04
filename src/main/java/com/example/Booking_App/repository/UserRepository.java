package com.example.Booking_App.repository;

import com.example.Booking_App.domain.User;
import com.example.Booking_App.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

}
