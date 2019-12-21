package com.docker.project.todo.controller;

import com.docker.project.todo.business.dto.FileDTO;
import com.docker.project.todo.business.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public FileDTO uploadFile(@RequestParam("file") MultipartFile file){
        return fileService.storeFile(file);
    }

    @GetMapping("/download/{fileId}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String fileId){
        FileDTO fileDTO = fileService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDTO.getFile_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement;filename=\"" + fileDTO.getFile_name() + "\"")
                .body(new ByteArrayResource(fileDTO.getData()));
    }
}
