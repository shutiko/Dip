package com.example.diplom.repository;

import com.example.diplom.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.io.File;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<File, String> {
    Optional<File> findByFilename(String filename);
}
