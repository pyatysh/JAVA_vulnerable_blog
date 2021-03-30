package com.javaAPI.blog_V3.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileService {

    public static void copyFile(Path source, Path dest) throws IOException {
        Files.copy(source, dest, REPLACE_EXISTING);
    }
}
