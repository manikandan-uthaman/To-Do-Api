package com.docker.project.todo.business.service.impl;

import com.docker.project.todo.business.dto.FileDTO;
import com.docker.project.todo.business.service.FileService;
import com.docker.project.todo.entity.DBFileBO;
import com.docker.project.todo.repository.DBFileRepository;
import com.docker.project.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private DBFileRepository dbFileRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public FileDTO storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            if(fileName.contains("..")){
                throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            DBFileBO dbFileBO = new DBFileBO(fileName, file.getContentType(), file.getBytes());
            dbFileBO = dbFileRepository.save(dbFileBO);
            FileDTO fileDTO = new FileDTO();
            fileDTO.setFile_id(dbFileBO.getId());
            fileDTO.setFile_name(dbFileBO.getFileName());
            fileDTO.setFile_type(dbFileBO.getFileType());
            return fileDTO;
        }catch (IOException ex){

        }
        return null;
    }

    @Override
    public FileDTO getFile(String fileId) {
        DBFileBO dbFileBO = dbFileRepository.findById(fileId).get();
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFile_id(dbFileBO.getId());
        fileDTO.setFile_name(dbFileBO.getFileName());
        fileDTO.setFile_type(dbFileBO.getFileType());
        fileDTO.setData(dbFileBO.getData());
        return fileDTO;
    }
}
