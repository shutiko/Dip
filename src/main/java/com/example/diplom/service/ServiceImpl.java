package com.example.diplom.service;


import com.example.diplom.mapper.InfoMapper;
import org.apache.commons.lang3.ArrayUtils;
import com.example.diplom.exception.FileException;
import com.example.diplom.exception.IncorrectInput;
//import com.example.diplom.mapper.FileInfoMapper;
import com.example.diplom.repository.Repository;
import com.example.diplom.entity.File;
import com.example.diplom.dto.FileInfoDto;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceImpl implements com.example.diplom.service.Service {
    private final Repository repository;
    private final FileManager fileManager;
    private final InfoMapper mapper;

    @Override
    public void saveFile(String filename, MultipartFile file) {
        try {
            if (repository.findByFilename(filename).isPresent()) {
                throw new IncorrectInput(String.format("File with name %s already exists", filename));
            }

            if (file == null) {
                throw new IncorrectInput ("File is not attached to request");
            }

            File uploadedFile = createFileInfo(filename, file);
            fileManager.uploadFile(file.getBytes(), uploadedFile.getHash(), filename);
            repository.save(uploadedFile);

        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        }
    }

    @Override
    public List<FileInfoDto> getFiles(int limit) {
        return repository.findAll(Pageable.ofSize(limit))
                .map(mapper::toFileInfoDto)
                .toList();
    }

    private File createFileInfo(String filename, MultipartFile file) throws IOException {
        LocalDateTime createdTime = LocalDateTime.now();

        String hash = UUID.nameUUIDFromBytes (
                ArrayUtils.addAll(file.getBytes(), createdTime.toString().getBytes())).toString();

        return File.builder()
                .hash(hash)
                .filename(filename)
                .size(file.getSize())
                .createdTime(createdTime)
                .build();
    }

    private File getExistingFile(String filename) {
        return repository.findByFilename(filename).orElseThrow(
                () -> new IncorrectInput(String.format("File with name %s does not exist", filename)));
    }
}
