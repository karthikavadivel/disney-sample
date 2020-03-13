package com.disney.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.sample.domain.User;
import com.disney.sample.exception.BusinessException;
import com.disney.sample.repository.UserRepository;
import com.disney.sample.service.UserService;
import com.disney.sample.util.EncryptionUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EncryptionUtil encryptionUtil;

	@Override
	public User createUser(User inputUser) {
		userRepo.findByUserName(inputUser.getUserName()).ifPresent(user -> {
			throw new BusinessException("User Name '" + user.getUserName() + "' Already Exists");
		});

		inputUser.setPassword(encryptionUtil.encode(inputUser.getPassword()));

		return userRepo.save(inputUser);
	}

	@Override
	public User login(String userName, String inputPassword) {
		var user = getUserByName(userName);
		var passwordMatches = encryptionUtil.matches(inputPassword, user.getPassword());

		if (passwordMatches) {
			return user;
		} else {
			throw new BusinessException("Password is not correct");
		}
	}

	@Override
	public User changePassword(User user, String newPassword) {
		user.setPassword(encryptionUtil.encode(newPassword));

		return userRepo.save(user);
	}

	private User getUserByName(String userName) {
		var user = userRepo.findByUserName(userName);

		return user.orElseThrow(() -> new BusinessException("User Name '" + userName + "' Does Not Exist."));
	}
}
