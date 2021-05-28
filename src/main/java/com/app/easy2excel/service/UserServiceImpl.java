package com.app.easy2excel.service;

import com.app.easy2excel.dto.UserDTO;
import com.app.easy2excel.entity.User;
import com.app.easy2excel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setId(userDTO.getId());
        User savedUser =  userRepository.save(user);
        return getUserDetailsById(savedUser.getId());
    }

    @Override
    public UserDTO getUserDetailsById(int id) {
        User user= userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found" +id));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUserList() {
        return userRepository.findAll().stream()
                .map(user -> getUserDetailsById(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUserById(int id, UserDTO userDTO) {
        User dbUser = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found" +id));
        dbUser.setName(userDTO.getName());
        dbUser.setEmail(userDTO.getEmail());
        userRepository.save(dbUser);
        return getUserDetailsById(id);
    }

    @Override
    public void deleteUserById(int id) {

        userRepository.deleteById(id);
    }
}
