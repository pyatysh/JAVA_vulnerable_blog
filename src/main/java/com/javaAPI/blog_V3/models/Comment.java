package com.javaAPI.blog_V3.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comId;
    private String fullTextCom;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> imgToComment;

    public Comment() {
    }

    public Comment(Long comId, String fullTextCom, List<Image> imgToComment) {
        this.comId = comId;
        this.fullTextCom = fullTextCom;
        this.imgToComment = imgToComment;
    }


    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getFullTextCom() {
        return fullTextCom;
    }

    public void setFullTextCom(String fullTextCom) {
        this.fullTextCom = fullTextCom;
    }

    public List<Image> getImgToComment() {
        return imgToComment;
    }

    public void setImgToComment(List<Image> imgToComment) {
        this.imgToComment = imgToComment;
    }
}
