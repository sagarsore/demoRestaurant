package com.task.Rudolf.task.service.Impl;


import com.task.Rudolf.task.Exception.UserAlreadyExistException;
import com.task.Rudolf.task.entities.UserEntity;
import com.task.Rudolf.task.repository.UserRepo;
import com.task.Rudolf.task.service.UserService;
import com.task.Rudolf.task.web.data.UserData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepo userRepository;


    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        System.out.println("savinng user");
        userRepository.save(userEntity);

    }


    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email)!=null ? true : false;
    }

    @Override
    public boolean verifyUser(String username, String password)  {

        UserEntity user = userRepository.findByEmail(username);
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Password mismatch.");
        }
        return true;
    }
//
//    @Override
//    public UserEntity getUserById(String id) throws UnkownIdentifierException {
//        UserEntity user= userRepository.findByEmail(id);
//        if(user == null || BooleanUtils.isFalse(user.getAccountVerified())){
//            // we will ignore in case account is not verified or account does not exists
//            throw new UnkownIdentifierException("unable to find account or account is not active");
//        }
//        return user;
//    }



}