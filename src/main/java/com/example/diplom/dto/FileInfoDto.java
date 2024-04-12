package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileInfoDto {
    private  String filename;
    private Long size;
}