package com.training.TodoAppSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.TodoAppSpringBoot.model.SignupForm;
import com.training.TodoAppSpringBoot.repository.UsersRepository;

/**
 * created by pc on Mar, 2020
 */

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

	@Override
	public SignupForm createUsers(SignupForm signupForm) {
        return usersRepository.save(signupForm);
	}

	@Override
	public List<SignupForm> getAllUsers() {
        return (List<SignupForm>) usersRepository.findAll();

	}

	@Override
	public SignupForm getUsersById(Integer id) {
		 Optional<SignupForm> dbOrder = usersRepository.findById(id);
	     return dbOrder.orElse(null);
	}

	@Override
	public boolean deleteUsersById(Integer id) {
		usersRepository.deleteById(id);
        return getUsersById(id) == null;
	}
}