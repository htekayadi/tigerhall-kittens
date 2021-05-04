package com.tigerhall.api.rest.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.tigerhall.api.rest.exception.GenericRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@ConditionalOnProperty(name = "aws.endpointUrl")
@Service
@Slf4j
public class AWSStorageClientImpl implements AWSStorageClient {

    private final String endpointUrl;
    private final String awsS3Bucket;
    private final AmazonS3 client;
    private final TransferManager transferManager;

    public AWSStorageClientImpl(
            @Value("${aws.endpointUrl}") String endpointUrl,
            @Value("${aws.s3.bucket}") String awsS3Bucket,
            @Value("${aws.s3.uploadThreshold}") String uploadThresholdInMB,
            AmazonS3 client) {
        this.endpointUrl = endpointUrl;
        this.awsS3Bucket = awsS3Bucket;
        this.client = client;
        this.transferManager =
                TransferManagerBuilder.standard()
                        .withS3Client(client)
                        .withMultipartUploadThreshold(Long.parseLong(uploadThresholdInMB) * 1024 * 1025)
                        .build();
    }

    @Override
    public String uploadFile(File file) {
        String url;
        try {
            uploadFileToS3(file);
            url = generateUrl(file);
        } finally {
            delete(file);
        }
        return url;
    }

    private void uploadFileToS3(File file) {
        String keyName = file.getName();
        try {
            transferManager.upload(awsS3Bucket, keyName, file).waitForUploadResult();
        } catch (InterruptedException e) {
            log.error("Interrupted uploading file to S3", e);
            throw new GenericRuntimeException(e);
        }
    }

    private String generateUrl(File file) {
        return endpointUrl + file.getName();
    }

    private void delete(File file) {
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            log.error(
                    "error encountered while deleting the file : {} with cause : {} ",
                    file.getName(),
                    e.getStackTrace());
        }
    }
}
