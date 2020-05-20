package com.training.TodoAppSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.TodoAppSpringBoot.model.Tasks;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	
}