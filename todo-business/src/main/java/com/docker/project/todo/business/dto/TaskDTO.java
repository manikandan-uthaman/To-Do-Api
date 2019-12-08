package com.docker.project.todo.business.dto;

import com.docker.project.todo.business.constants.TaskStatus;

public class TaskDTO {
    int taskId;
    String taskName;
    String taskDescription;
    String targetDate;
    TaskStatus taskStatus;
}
