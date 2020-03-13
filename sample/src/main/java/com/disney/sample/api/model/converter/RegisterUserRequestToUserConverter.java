package com.disney.sample.api.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.disney.sample.api.model.request.RegisterUserRequest;
import com.disney.sample.domain.User;

@Component
public class RegisterUserRequestToUserConverter implements Converter<RegisterUserRequest, User> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User convert(RegisterUserRequest source) {
		return modelMapper.map(source, User.class);
	}
}
