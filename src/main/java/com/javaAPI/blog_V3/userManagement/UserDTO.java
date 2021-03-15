package com.javaAPI.blog_V3.userManagement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String username;
    private String password;
}
