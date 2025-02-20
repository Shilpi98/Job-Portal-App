package com.jobportal.services;

import org.springframework.stereotype.Service;
import java.util.*;

import com.jobportal.entity.UsersType;
import com.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {
	
	private final UsersTypeRepository usersTypeRepository;

	public UsersTypeService(UsersTypeRepository usersTypeRepository) {
		this.usersTypeRepository=usersTypeRepository;
		
	}
	
	public List<UsersType> getAll() {
		return usersTypeRepository.findAll();
	}

}
