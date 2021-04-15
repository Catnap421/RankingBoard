package com.bleum.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public void insertUser(UserDTO dto) {
        userDAO.insertUser(dto);
    }

    @Override
    public UserDTO getUser(UserDTO dto) {
        return userDAO.getUser(dto);
    }

    @Override
    public boolean existUser(UserDTO dto) {
        return userDAO.existUser(dto);
    }
}
