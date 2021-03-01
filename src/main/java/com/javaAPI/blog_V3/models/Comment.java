package com.javaAPI.blog_V3.models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comId;
    private String fullTextCom;

    public Comment() {
    }

    public Comment(Long comId, String fullTextCom) {
        this.comId = comId;
        this.fullTextCom = fullTextCom;
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

}
