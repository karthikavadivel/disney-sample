package com.disney.sample.api.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.disney.sample.api.model.response.UserDetailsResponse;
import com.disney.sample.domain.User;

@Component
public class UserToUserDetailResponseConverter implements Converter<User, UserDetailsResponse> {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetailsResponse convert(User source) {
		return modelMapper.map(source, UserDetailsResponse.class);
	}
}
