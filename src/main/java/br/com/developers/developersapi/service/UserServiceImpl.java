package br.com.developers.developersapi.service;

import org.springframework.stereotype.Service;

import br.com.developers.developersapi.domain.model.User;
import br.com.developers.developersapi.domain.repository.UserRepository;
import br.com.developers.developersapi.dto.UserDataTransferObject;
import br.com.developers.developersapi.service.convert.UserConvert;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
//import lombok.AccessLevel;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public UserDataTransferObject save(UserDataTransferObject userDTO) {
		User user = UserConvert.convert(userDTO);
		userRepository.saveAndFlush(user);
		return userDTO;
	}

	@Override
	public UserDataTransferObject find(String identifier) {
		UserDataTransferObject userDataTransferObject = null;
		Optional<User> optionalUser = getOptionalUserByIdentifier(identifier);

		User user = UserConvert.convertOptional(optionalUser);
		userDataTransferObject = UserConvert.convertToDataTransferObject(user);
		return userDataTransferObject;
	}

	@Override
	public void delete(String identifier) {
		Optional<User> optionalUser = getOptionalUserByIdentifier(identifier);

		User user = UserConvert.convertOptional(optionalUser);

		userRepository.delete(user);
	}

	@Override
	public void update(String identifier, UserDataTransferObject userDTO) {
		Optional<User> optionalUser = getOptionalUserByIdentifier(identifier);
		User user = UserConvert.convertOptional(optionalUser);

		user.setFullName(userDTO.getFullName());
		user.setIdentifier(userDTO.getIdentifier());

		userRepository.save(user);
	}

	@Override
	public Page<UserDataTransferObject> findAll(Pageable pageable) {
		return userRepository.findAll(pageable).map(user -> UserConvert.convertToDataTransferObject(user));
	}

	private Optional<User> getOptionalUserByIdentifier(String identifier) {
		return userRepository.findByIdentifier(identifier);
	}

}
