package com.example.api_laboratory_inventory.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "managers")
@Getter
@Setter
@NoArgsConstructor
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String firstName;

	@Column(nullable = false, length = 255)
	private String lastName;

	@Column(nullable = false, length = 255, unique = true)
	private String email;

	@Column(nullable = false, length = 255)
	private String passwordHashed;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Instant createdAt;

	@UpdateTimestamp
	@Column(nullable = false)
	private Instant updatedAt;

}
