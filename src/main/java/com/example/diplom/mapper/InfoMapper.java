package com.example.diplom.mapper;

import com.example.diplom.dto.FileInfoDto;
import com.example.diplom.entity.File;
import org.springframework.stereotype.Component;

@Component
public class InfoMapper {
    public FileInfoDto toFileInfoDto (File file) {
       return new FileInfoDto()
               .setFilename(file.getFilename())
               .setSize(file.getSize());

    }
}
