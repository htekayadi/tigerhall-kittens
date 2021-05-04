package com.tigerhall.api.util;

import com.tigerhall.api.rest.exception.ConvertImageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
public class FileUtils {

    public static File convertToFile(MultipartFile multipartFile) {
        String imageType = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File file =
                new File(
                        "./" + generateFileName(UUID.randomUUID().toString(), imageType));

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException e) {
            log.error(
                    "error encountered while converting multipart file : {} with cause : {}",
                    multipartFile.getName(),
                    e.getStackTrace());
            throw new ConvertImageException("Error in uploading file : ", e.getCause());
        }

        return file;
    }

    public static void delete(File file) {
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            log.error(
                    "error encountered while deleting the file : {} with cause : {} ",
                    file.getName(),
                    e.getStackTrace());
        }
    }

    public static String generateFileName(String imageId, String imageType) {
        return imageId + "./" + imageType;
    }
}
