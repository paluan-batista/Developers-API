package br.com.developers.developersapi.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.developers.developersapi.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID>{
	
	Optional<User> findByIdentifier(String identifier);

}
