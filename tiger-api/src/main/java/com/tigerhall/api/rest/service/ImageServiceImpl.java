package com.tigerhall.api.rest.service;

import com.tigerhall.api.rest.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.imgscalr.Scalr;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@ConditionalOnProperty(name = "aws.s3.bucket")
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

  private final Integer IMAGE_WIDTH = 250;
  private final Integer IMAGE_HEIGHT = 200;

  @Override
  public File getResizedImage(File file, String filename, Integer width, Integer height)
      throws IOException {
    BufferedImage img = null;
    isValidImage(file.getName());
    File resizeImage = new File("./" + filename);
    try (FileInputStream fis = new FileInputStream(file)) {
      img = ImageIO.read(fis);
    } catch (IOException e) {
      log.error(
          "error encountered while creating file : {} with cause : {}",
          filename,
          e.getStackTrace());
      throw e;
    }
    BufferedImage thumbImg =
        Scalr.resize(
            img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
    ImageIO.write(thumbImg, getFileType(file), resizeImage);
    return resizeImage;
  }

  @Override
  public File getResizedImage(File file) throws IOException {
    return getResizedImage(
        file,
        "resized-" + file.getName(),
        IMAGE_WIDTH,
        IMAGE_HEIGHT);
  }

  private void isValidImage(String filename) {
    if (!("JPEG".equalsIgnoreCase(getFileType(filename))
            || "JPG".equalsIgnoreCase(getFileType(filename))
            || "PNG".equalsIgnoreCase(getFileType(filename)))) {
      throw new InvalidInputException("Image should be in JPG/JPEG/PNG formats");
    }
  }

  private String getFileType(File file) {
    String fileName = file.getName();
    return fileName.substring(fileName.lastIndexOf('.') + 1);
  }

  private String getFileType(String filename) {
    return filename.substring(filename.lastIndexOf('.') + 1);
  }

}
