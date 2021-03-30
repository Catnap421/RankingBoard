package com.merang.bleum.biz.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String birth;

    @Override
    public String toString(){
        return "id: " + getId() + ", email: " + getEmail() + ", nickname: " + getNickname() + ", birth: " + getBirth();
    }
}
