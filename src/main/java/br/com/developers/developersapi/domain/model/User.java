package br.com.developers.developersapi.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "identifier" }) })
public class User implements Serializable {

	private static final long serialVersionUID = -9185666286872927232L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "identifier")
	private String identifier;

}
