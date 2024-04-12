package com.example.diplom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
//@Table(
//        schema = "cloud_service",
//        indexes = {@Index(columnList = "filename", name = "filename_idx")})
//@Table (schema =  "bd", name = "filename")
@Table
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Accessors(chain = true)
public class File {

    @Id
    private String hash;

    private String filename;

    private Long size;

    private LocalDateTime createdTime;
}