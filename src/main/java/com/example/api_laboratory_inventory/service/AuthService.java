package com.example.api_laboratory_inventory.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api_laboratory_inventory.dto.RegisterRequest;
import com.example.api_laboratory_inventory.dto.RegisterResponse;
import com.example.api_laboratory_inventory.entity.Manager;
import com.example.api_laboratory_inventory.exception.EmailAlreadyRegisteredException;
import com.example.api_laboratory_inventory.repository.ManagerRepository;

@Service
public class AuthService {

	private final ManagerRepository managerRepository;
	private final PasswordEncoder passwordEncoder;

	public AuthService(ManagerRepository managerRepository, PasswordEncoder passwordEncoder) {
		this.managerRepository = managerRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public RegisterResponse register(RegisterRequest request) {
		if (managerRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyRegisteredException(request.getEmail());
		}

		var manager = new Manager();
		manager.setFirstName(request.getFirstName());
		manager.setLastName(request.getLastName());
		manager.setEmail(request.getEmail());
		manager.setPasswordHashed(passwordEncoder.encode(request.getPassword()));

		var saved = managerRepository.save(manager);

		return new RegisterResponse(
				saved.getId(),
				saved.getFirstName(),
				saved.getLastName(),
				saved.getEmail(),
				saved.getCreatedAt());
	}

}
