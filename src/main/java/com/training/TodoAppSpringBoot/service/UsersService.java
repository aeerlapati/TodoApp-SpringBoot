package com.training.TodoAppSpringBoot.service;

import com.training.TodoAppSpringBoot.model.SignupForm;

import java.util.List;

public interface UsersService {


    SignupForm createUsers(SignupForm signupForm);

    List<SignupForm> getAllUsers();

    SignupForm getUsersById(String id);

    boolean deleteUsersById(String id);
}