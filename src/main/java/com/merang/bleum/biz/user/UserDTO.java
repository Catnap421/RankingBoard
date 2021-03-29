package com.merang.bleum.biz.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String birth;
}
