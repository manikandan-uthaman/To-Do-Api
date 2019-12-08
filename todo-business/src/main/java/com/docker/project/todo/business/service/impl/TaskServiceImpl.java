package com.docker.project.todo.business.service.impl;

import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.business.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDTO> getAllTasks() {
        return new ArrayList<>();
    }
}
