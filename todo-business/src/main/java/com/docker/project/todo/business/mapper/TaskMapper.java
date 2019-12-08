package com.docker.project.todo.business.mapper;

import com.docker.project.todo.business.constants.TaskStatus;
import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.entity.TaskBO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class TaskMapper {
    public TaskDTO mapTaskBOToDto(TaskBO taskBO){
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(taskBO.getId());
        dto.setTaskName(taskBO.getTaskName());
        dto.setTaskDescription(taskBO.getTaskDesc());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String text = df.format(taskBO.getTargetDate());
        dto.setTargetDate(text);
        dto.setTaskStatus(TaskStatus.valueOf(taskBO.getTaskStatus()));
        return dto;
    }

    public TaskBO mapTaskDtoToBo(TaskDTO taskDTO){
        TaskBO bo = new TaskBO();
        bo.setTaskName(taskDTO.getTaskName());
        bo.setTaskDesc(taskDTO.getTaskDescription());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = java.sql.Date.valueOf("9999-12-31");
        try {
            dt = new Date(df.parse(taskDTO.getTargetDate()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bo.setTargetDate(dt);
        bo.setTaskStatus(taskDTO.getTaskStatus().toString());
        return bo;
    }
}
