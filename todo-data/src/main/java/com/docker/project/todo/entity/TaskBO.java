package com.docker.project.todo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tasks")
public class TaskBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_desc")
    private String taskDesc;

    @Column(name = "target_date")
    private Date targetDate;

    @Column(name="task_status")
    private String taskStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskBO{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", targetDate=" + targetDate +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
