package com.docker.project.todo.business.service.impl;

import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.business.mapper.TaskMapper;
import com.docker.project.todo.business.service.TaskService;
import com.docker.project.todo.entity.TaskBO;
import com.docker.project.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskDTO> getAllTasks(Long userId) {
        List<TaskDTO> tasksList = new ArrayList<>();
        taskRepository.findAllByUserId(userId).forEach(bo -> {
            tasksList.add(taskMapper.mapTaskBOToDto(bo));
        });
        return tasksList;
    }

    @Override
    public String createTask(TaskDTO task, Long userId) {
        TaskBO bo = taskRepository.save(taskMapper.mapTaskDtoToBo(task, userId));
        return bo.getId().toString();
    }

    @Override
    public int updateStatus(TaskDTO task, Long userId) {
        return taskRepository.updateTaskStatus(task.getTaskId(), task.getTaskStatus().toString(), userId);
    }

    @Override
    public void deleteTask(int taskId, Long userId) {
        taskRepository.deleteTask(taskId, userId);
    }
}
