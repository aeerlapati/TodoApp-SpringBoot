package com.training.TodoAppSpringBoot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.training.TodoAppSpringBoot.model.Tasks;

public interface TasksService {


    Tasks createTasks(Tasks tasks);

    List<Tasks> getAllTasks();

    Tasks getTasksById(Integer id);

    boolean deleteTasksById(Integer id);
    
}