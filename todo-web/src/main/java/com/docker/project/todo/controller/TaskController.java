package com.docker.project.todo.controller;

import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.business.service.TaskService;
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
    public List<TaskDTO> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    @ResponseBody
    public String createTask(@RequestBody TaskDTO task){
        System.out.print(task.toString());
        return taskService.createTask(task);
    }

    @PostMapping("/update")
    @ResponseBody
    public Integer updateTaskStatus(@RequestBody TaskDTO task){
        return taskService.updateStatus(task);
    }

    @GetMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable("taskId") int taskId){
        taskService.deleteTask(taskId);
    }
}
