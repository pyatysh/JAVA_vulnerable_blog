package com.javaAPI.blog_V3.controllers;

import com.javaAPI.blog_V3.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class LFIController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    FileService fileService;

    @Value("${myApp.folder}") String folder;
    @Value("${myApp.folder.downloads}") String downloads;

    @GetMapping("/blog/files")
    public String downloadFile(@RequestParam(value = "f") String fileName) throws IOException {

        Path source = Paths.get(folder,"\\", fileName);
        Path dest = Paths.get(downloads, "\\", "copy.txt");

        fileService.copyFile(source, dest);

        return "redirect:/blog";
        }
    }

