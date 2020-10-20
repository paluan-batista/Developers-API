package com.developers.developersapi.utils;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import br.com.developers.developersapi.domain.model.User;

public class UserEntityUtilsTest implements ArgumentsProvider, UsersConstants {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(User.newBuilder().fullName(FULL_NAME).identifier(IDENTIFIER).build()).map(Arguments::of);
	}

}
