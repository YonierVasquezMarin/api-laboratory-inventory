package com.example.api_laboratory_inventory.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {

	public EmailAlreadyRegisteredException(String email) {
		super("El correo electrónico ya está registrado: " + email);
	}

}
