package br.com.developers.developersapi.dto;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Getter
@Setter
@Builder(builderMethodName = "newBuilder")
public class UserDataTransferObject {

	@JsonProperty("full_name")
	@NotNull
	private String fullName;

	@JsonProperty("identifier")
	@NotNull
	private String identifier;
}
