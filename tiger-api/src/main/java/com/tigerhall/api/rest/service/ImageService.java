package com.tigerhall.api.rest.service;

import java.io.File;
import java.io.IOException;

// This services is to use for compress the the images on the basics of given height and width.
// Also method getResizedImage is used to get list of Image with different size for given Image
public interface ImageService {

    File getResizedImage(File file, String filename, Integer width, Integer height)
            throws IOException;

    File getResizedImage(File file) throws IOException;
}
