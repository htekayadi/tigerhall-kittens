package com.tigerhall.api.rest;

import com.tigerhall.api.KeyConstants;
import com.tigerhall.api.mapper.TigerMapper;
import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.rest.dto.CreateTigerDto;
import com.tigerhall.api.rest.dto.MediaDto;
import com.tigerhall.api.rest.dto.TigerDto;
import com.tigerhall.api.rest.exception.ResizeImageException;
import com.tigerhall.api.rest.service.AWSStorageClient;
import com.tigerhall.api.rest.service.ImageService;
import com.tigerhall.api.rest.service.TigerService;
import com.tigerhall.api.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class StorageController {

    private final AWSStorageClient awsStorageClient;
    private final ImageService imageService;

    @PostMapping
    public MediaDto upload(MultipartFile multipartFile) {
        File file = FileUtils.convertToFile(multipartFile);
        String url;
        try {
            url = awsStorageClient.uploadFile(imageService.getResizedImage(file));
        } catch (IOException e) {
            throw new ResizeImageException(KeyConstants.ERROR_IN_UPLOAD_FILE, e.getCause());
        }

        return new MediaDto(url);
    }
}
