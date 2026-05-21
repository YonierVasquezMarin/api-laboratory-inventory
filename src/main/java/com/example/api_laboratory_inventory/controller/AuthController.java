package com.example.api_laboratory_inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_laboratory_inventory.dto.RegisterRequest;
import com.example.api_laboratory_inventory.dto.RegisterResponse;
import com.example.api_laboratory_inventory.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
		var response = authService.register(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
