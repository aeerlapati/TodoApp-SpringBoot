package com.training.TodoAppSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.training.TodoAppSpringBoot.model.Tasks;
import com.training.TodoAppSpringBoot.repository.TasksRepository;


@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksRepository tasksRepository;

	@Override
	public Tasks createTasks(Tasks tasks) {
		return tasksRepository.save(tasks);
	}

	@Override
	public List<Tasks> getAllTasks() {
		return (List<Tasks>) tasksRepository.findAll();
	}

	@Override
	public Tasks getTasksById(Integer id) {
		Optional<Tasks> dbOrder = tasksRepository.findById(id);
	     return dbOrder.orElse(null);
	}

	@Override
	public boolean deleteTasksById(Integer id) {
		tasksRepository.deleteById(id);
        return getTasksById(id) == null;
	}
	
}