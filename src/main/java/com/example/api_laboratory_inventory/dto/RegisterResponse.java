package com.example.api_laboratory_inventory.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Instant createdAt;

}
