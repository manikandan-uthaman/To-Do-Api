package com.docker.project.todo.controller;

import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.business.service.TaskService;
import com.docker.project.todo.security.CurrentUser;
import com.docker.project.todo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/get")
    @ResponseBody
    public List<TaskDTO> getTasks(@CurrentUser UserPrincipal currentUser){
        return taskService.getAllTasks(currentUser.getId());
    }

    @PostMapping("/add")
    @ResponseBody
    public String createTask(@RequestBody TaskDTO task, @CurrentUser UserPrincipal currentUser){
        return taskService.createTask(task, currentUser.getId());
    }

    @PostMapping("/update")
    @ResponseBody
    public Integer updateTaskStatus(@RequestBody TaskDTO task, @CurrentUser UserPrincipal currentUser){
        return taskService.updateStatus(task, currentUser.getId());
    }

    @GetMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable("taskId") int taskId, @CurrentUser UserPrincipal currentUser){
        taskService.deleteTask(taskId, currentUser.getId());
    }
}
