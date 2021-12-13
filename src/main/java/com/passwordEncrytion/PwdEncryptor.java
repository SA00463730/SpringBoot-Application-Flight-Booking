package com.passwordEncrytion;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PwdEncryptor {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pwd=passwordEncoder.encode("demo@123");
		System.out.println(pwd);
	}

}
