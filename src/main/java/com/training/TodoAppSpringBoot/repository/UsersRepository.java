package com.training.TodoAppSpringBoot.repository;

import com.training.TodoAppSpringBoot.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends CrudRepository<SignupForm, String> {

}