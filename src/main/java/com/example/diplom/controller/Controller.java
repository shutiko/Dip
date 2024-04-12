package com.example.diplom.controller;

import com.example.diplom.dto.FileDto;
import com.example.diplom.dto.FileInfoDto;
import com.example.diplom.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class Controller {
    private final Service service;

    @PreAuthorize("hasRole('ROLE_Administrator')")
    //@PreAuthorize("hasAnyRole('ROLE_User', 'ROLE_Administrator')")
    //@PreAuthorize("hasRole('ROLE_User')")
    @PostMapping("/file")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@RequestParam String filename, @RequestBody MultipartFile file) {
        service.saveFile(filename, file);

    }

//    @PreAuthorize("hasRole('ROLE_Administrator')")
//    @DeleteMapping("/file")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteFile(@RequestParam String filename) {
//        service.deleteFile(filename);
//    }
//
//    @PreAuthorize("hasAnyRole('ROLE_User', 'ROLE_Administrator')")
//    @GetMapping("/file")
//    @ResponseStatus(HttpStatus.OK)
//    public FileDto downloadFile(@RequestParam String filename) {
//        return service.downloadFile(filename);
//    }
//
//    @PreAuthorize("hasRole('ROLE_Administrator')")
//    @PutMapping("/file")
//    @ResponseStatus(HttpStatus.OK)
//    public void editFileName(@RequestParam String filename, @RequestBody Map<String, String> newName) {
//        service.editFilename(filename, newName.get("filename"));
//    }
//
    //@CrossOrigin
    @PreAuthorize("hasAnyRole('ROLE_User', 'ROLE_Administrator')")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<FileInfoDto> getFiles(@RequestParam int limit) {
        return service.getFiles(limit);
    }
}
