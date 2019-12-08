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
    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> tasksList = new ArrayList<>();
        taskRepository.findAll().forEach(bo -> {
            tasksList.add(taskMapper.mapTaskBOToDto(bo));
        });
        return tasksList;
    }

    @Override
    public String createTask(TaskDTO task) {
        TaskBO bo = taskRepository.save(taskMapper.mapTaskDtoToBo(task));
        return bo.getId().toString();
    }
}
