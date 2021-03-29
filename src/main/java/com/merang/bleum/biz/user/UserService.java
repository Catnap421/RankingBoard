package com.merang.bleum.biz.user;

public interface UserService {
    public void insertUser(UserDTO dto);

    public UserDTO getUser(UserDTO dto);
}
