package com.tigerhall.api.rest.service;

import java.io.File;
import java.util.List;

public interface AWSStorageClient {

  String uploadFile(File file);
}
