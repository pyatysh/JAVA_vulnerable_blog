package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.models.Image;
import com.javaAPI.blog_V3.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image uploadImg(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImgContent(file.getBytes());
        return imageRepository.save(image);
    }

    public Optional<Image> getImg(String imgId) {
        return imageRepository.findById(imgId);
    }

    public Iterable<Image> findAllImg() {
        return imageRepository.findAll();
    }
}
