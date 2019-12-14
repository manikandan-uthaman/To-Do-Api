package com.docker.project.todo.business.service;

import com.docker.project.todo.business.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks();
    String createTask(TaskDTO task);
    int updateStatus(TaskDTO task);
    void deleteTask(int taskId);
}
