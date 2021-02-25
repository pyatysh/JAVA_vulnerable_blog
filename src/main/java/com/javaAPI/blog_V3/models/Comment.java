package com.javaAPI.blog_V3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comId;

    private String fullTextCom;

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getFullTextCom() {
        return fullTextCom;
    }

    public void setFullTextCom(String fullText) {
        this.fullTextCom = fullText;
    }
}
