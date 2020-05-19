package com.training.TodoAppSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.TodoAppSpringBoot.model.SignupForm;


@Repository
public interface UsersRepository extends JpaRepository<SignupForm, Integer> {

}