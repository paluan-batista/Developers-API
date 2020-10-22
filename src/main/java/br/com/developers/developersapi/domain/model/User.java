package br.com.developers.developersapi.domain.model;

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
@Entity
@Builder(builderMethodName = "newBuilder")
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"identifier"})})
public class User extends UserAudit {

	private static final long serialVersionUID = -9185666286872927232L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "identifier")
	private String identifier;

}
