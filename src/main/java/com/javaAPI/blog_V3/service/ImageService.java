package com.javaAPI.blog_V3.service;

import com.javaAPI.blog_V3.models.Image;
import com.javaAPI.blog_V3.repo.ImageRepository;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
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

    public static void saveImageXXE(MultipartFile imageFile) throws Exception {
        byte[] bytes = imageFile.getBytes();

        PNGTranscoder t = new PNGTranscoder();
        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(bytes));

        FileOutputStream ostream = new FileOutputStream("new.png");
        TranscoderOutput output = new TranscoderOutput(ostream);

        t.transcode(input, output);

        ostream.flush();
        ostream.close();
        System.exit(0);
    }
}
