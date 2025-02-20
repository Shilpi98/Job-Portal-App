package com.jobportal.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	
	Optional<Users> findByEmail(String email);
}
