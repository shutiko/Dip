package com.example.diplom.service;

import com.example.diplom.dto.FileDto;
import com.example.diplom.dto.FileInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Service {
    void saveFile(String filename, MultipartFile file);
//    void deleteFile(String filename);
//    FileDto downloadFile(String filename);
//    void editFilename(String filename, String newName);
    List<FileInfoDto> getFiles(int limit);
}
