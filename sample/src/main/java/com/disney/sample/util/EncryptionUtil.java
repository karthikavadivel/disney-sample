package com.disney.sample.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {

	private static PasswordEncoder encoder = new BCryptPasswordEncoder(10);

	public String encode(String inputPassword) {
		return encoder.encode(inputPassword);
	}

	public boolean matches(String inputPassword, String encodedPassword) {
		return encoder.matches(inputPassword, encodedPassword);
	}
}
