package com.disney.sample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String userName;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String lastName;

}
