package br.com.developers.developersapi.service;

import org.springframework.data.domain.Pageable;

import br.com.developers.developersapi.dto.UserDataTransferObject;

import org.springframework.data.domain.Page;

public interface UserService {

	UserDataTransferObject save(UserDataTransferObject userDTO);

	UserDataTransferObject find(String identifier);

	void delete(String uuid);

	void update(String uuid, UserDataTransferObject userDTO);

	Page<UserDataTransferObject> findAll(Pageable pageable);

}
