package com.ThinkOn.Skill.service;

import com.ThinkOn.Skill.dto.UserDTO;
import com.ThinkOn.Skill.entity.User;
import com.ThinkOn.Skill.exception.NotFoundException;
import com.ThinkOn.Skill.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers(){

        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        for(User user : userList){
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhoneNumber(user.getPhoneNumber());

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    public UserDTO getUserById(int id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            throw new NotFoundException("User with id "+id+" not found");
        }

        User user = optionalUser.get();
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public UserDTO addUser(User user) {
        User user1 = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user1,userDTO);
        return userDTO;
    }
    public UserDTO updateUserInfo(int id, @RequestBody UserDTO userDTO) throws NotFoundException{
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent()){
            throw new NotFoundException("User with id "+id+" not found");
        }

        User user1 = optionalUser.get();
        user1.setUserName(userDTO.getUserName());
        user1.setFirstName(userDTO.getFirstName());
        user1.setLastName(userDTO.getLastName());
        user1.setEmail(userDTO.getEmail());
        user1.setPhoneNumber(userDTO.getPhoneNumber());

        userRepository.save(user1);
        UserDTO userDTO1 = new UserDTO();
        BeanUtils.copyProperties(user1,userDTO1);


        return userDTO1;
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "Deleted the User with ID: "+ id;
    }




}
