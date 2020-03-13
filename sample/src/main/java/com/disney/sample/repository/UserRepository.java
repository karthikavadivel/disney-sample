package com.disney.sample.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.disney.sample.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> findByUserName(String userName);
}
