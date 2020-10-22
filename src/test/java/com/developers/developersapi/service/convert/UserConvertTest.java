package com.developers.developersapi.service.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.developers.developersapi.utils.UserDTOUtilsTest;
import com.developers.developersapi.utils.UsersConstants;

import br.com.developers.developersapi.domain.model.User;
import br.com.developers.developersapi.dto.UserDataTransferObject;
import br.com.developers.developersapi.service.convert.UserConvert;

public class UserConvertTest implements UsersConstants {

	@ParameterizedTest
	@ArgumentsSource(UserDTOUtilsTest.class)
	void shouldConvertDataTransferObjectToEntity(UserDataTransferObject usernDTO) {
		User user = UserConvert.convert(usernDTO);
		System.out.println(user.getFullName());
		System.out.println(user.getIdentifier());
		asserts(user.getFullName(), user.getIdentifier());
	}

	private void asserts(String fullName, String identifier) {
		assertEquals(FULL_NAME, fullName);
		assertEquals(IDENTIFIER, identifier);
	}
}
