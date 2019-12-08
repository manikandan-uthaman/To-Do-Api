package com.docker.project.todo.repository;

import com.docker.project.todo.entity.TaskBO;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskBO, Integer> {
}
