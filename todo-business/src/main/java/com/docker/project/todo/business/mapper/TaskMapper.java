package com.docker.project.todo.business.mapper;

import com.docker.project.todo.business.constants.TaskStatus;
import com.docker.project.todo.business.dto.TaskDTO;
import com.docker.project.todo.entity.TaskBO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class TaskMapper {
    public TaskDTO mapTaskBOToDto(TaskBO taskBO){
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(taskBO.getId());
        dto.setTaskName(taskBO.getTaskName());
        dto.setTaskDescription(taskBO.getTaskDesc());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(taskBO.getTargetDate());
        dto.setTargetDate(text);
        dto.setTaskStatus(TaskStatus.valueOf(taskBO.getTaskStatus()));
        Optional.ofNullable(taskBO.getFile()).ifPresent(file -> {
            dto.setFileId(file.getId());
            dto.setFileName(file.getFileName());
        });
        return dto;
    }

    public TaskBO mapTaskDtoToBo(TaskDTO taskDTO){
        TaskBO bo = new TaskBO();
        if(taskDTO.getTaskId() != 0){
            bo.setId(taskDTO.getTaskId());
        }
        bo.setTaskName(taskDTO.getTaskName());
        bo.setTaskDesc(taskDTO.getTaskDescription());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
