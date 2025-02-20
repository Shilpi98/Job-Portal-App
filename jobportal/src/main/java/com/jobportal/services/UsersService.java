package com.jobportal.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.Users;
import com.jobportal.repository.UsersRepository;
import java.util.*;

@Service
public class UsersService {
	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository=usersRepository;
	}
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrartionDate(new Date(System.currentTimeMillis()));
		return usersRepository.save(users);
	}
	
	public Optional<Users> getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
}
