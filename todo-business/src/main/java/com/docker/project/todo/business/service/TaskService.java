package com.docker.project.todo.business.service;

import com.docker.project.todo.business.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks(Long userId);
    String createTask(TaskDTO task, Long userId);
    int updateStatus(TaskDTO task, Long userId);
    void deleteTask(int taskId, Long userId);
}
