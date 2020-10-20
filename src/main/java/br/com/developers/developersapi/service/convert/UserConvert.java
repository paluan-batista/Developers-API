package br.com.developers.developersapi.service.convert;

import java.util.Optional;

import br.com.developers.developersapi.domain.model.User;
import br.com.developers.developersapi.dto.UserDataTransferObject;
import br.com.developers.developersapi.service.exception.UserNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConvert {

	static final String MESSAGE_NOT_FOUND_EXCEPTION = "User not found!";

	public static User convert(UserDataTransferObject userDTO) {
		return User.newBuilder().fullName(userDTO.getFullName()).identifier(userDTO.getIdentifier()).build();
	}

	public static User convertOptional(Optional<User> optionalUser) throws UserNotFoundException {
		return optionalUser.orElseThrow(() -> new UserNotFoundException(MESSAGE_NOT_FOUND_EXCEPTION));
	}

	public static UserDataTransferObject convertToDataTransferObject(User user) {
		return UserDataTransferObject.newBuilder().fullName(user.getFullName()).identifier(user.getIdentifier())
				.build();
	}
}
