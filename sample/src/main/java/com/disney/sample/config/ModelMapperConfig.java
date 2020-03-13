package com.disney.sample.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var rv = new ModelMapper();
		rv.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return rv;
	}
}
