package com.docker.project.todo.business.dto;

import com.docker.project.todo.business.constants.TaskStatus;

import java.io.Serializable;

public class TaskDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    int taskId;
    String taskName;
    String taskDescription;
    String targetDate;
    TaskStatus taskStatus;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
