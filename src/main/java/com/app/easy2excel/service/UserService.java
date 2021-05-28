package com.app.easy2excel.service;

import com.app.easy2excel.dto.UserDTO;
import com.app.easy2excel.entity.User;

import java.util.List;

public interface UserService {

    public UserDTO saveUser(UserDTO userDTO);

    public  UserDTO getUserDetailsById(int id);

    public List<UserDTO> getAllUserList();

    public  UserDTO updateUserById(int id, UserDTO userDTO);

    public void deleteUserById(int id);
}
