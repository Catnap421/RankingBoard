package com.merang.bleum.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void insertUser(UserDTO dto) {
        userDAO.insertUser(dto);
    }

    @Override
    public UserDTO getUser(UserDTO dto) {
        return userDAO.getUser(dto);
    }
}
