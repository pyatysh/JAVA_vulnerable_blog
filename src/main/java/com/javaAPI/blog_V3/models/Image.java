package com.javaAPI.blog_V3.models;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imgId;

    @Lob
    private byte[] imgContent;

    public Image() {
    }

    public Image(Long imgId, byte[] imgContent) {
        this.imgId = imgId;
        this.imgContent = imgContent;
    }

    public Long getImgId(String imgId) {
        return this.imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public byte[] getImgContent() {
        return imgContent;
    }

    public void setImgContent(byte[] imgContent) {
        this.imgContent = imgContent;
    }
}
