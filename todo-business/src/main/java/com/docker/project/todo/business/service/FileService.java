package com.docker.project.todo.business.service;

import com.docker.project.todo.business.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileDTO storeFile(MultipartFile file);
    FileDTO getFile(String fileId);
}
