package com.developers.developersapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.developers.developersapi.utils.UserEntityUtilsTest;
import com.developers.developersapi.utils.UsersConstants;

import br.com.developers.developersapi.domain.model.User;
import br.com.developers.developersapi.domain.repository.UserRepository;
import br.com.developers.developersapi.dto.UserDataTransferObject;
import br.com.developers.developersapi.service.UserService;
import br.com.developers.developersapi.service.UserServiceImpl;

public class UserServiceTest implements UsersConstants {

	private UserService service;
	private UserRepository repository;
	private UserDataTransferObject dto;

	@BeforeEach
	void before() {
		this.repository = Mockito.spy(UserRepository.class);
		this.service = new UserServiceImpl(this.repository);
		this.dto = UserDataTransferObject.newBuilder().fullName(FULL_NAME).identifier(IDENTIFIER).build();
	}

	@ParameterizedTest
	@ArgumentsSource(UserEntityUtilsTest.class)
	void shouldSaveUser(User user) {

		BDDMockito.given(this.repository.saveAndFlush(user)).willReturn(user);

		this.service.save(this.dto);

		BDDMockito.verify(this.repository, times(1)).saveAndFlush(any(User.class));
	}

	@ParameterizedTest
	@ArgumentsSource(UserEntityUtilsTest.class)
	void shouldFindUserByIdentifier(User user) {
		BDDMockito.given(this.repository.findByIdentifier(IDENTIFIER)).willReturn(Optional.of(user));

		this.service.find(IDENTIFIER);

		BDDMockito.verify(this.repository, times(1)).findByIdentifier(IDENTIFIER);
	}

}
