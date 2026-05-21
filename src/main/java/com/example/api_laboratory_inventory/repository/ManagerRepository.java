package com.example.api_laboratory_inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_laboratory_inventory.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Optional<Manager> findByEmail(String email);

	boolean existsByEmail(String email);

}
