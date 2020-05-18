package com.training.TodoAppSpringBoot.service;

import java.util.List;

import com.training.TodoAppSpringBoot.model.Tasks;

public interface TasksService {


    Tasks createTasks(Tasks tasks);

    List<Tasks> getAllTasks();

    Tasks getTasksById(String id);

    boolean deleteTasksById(String id);
}