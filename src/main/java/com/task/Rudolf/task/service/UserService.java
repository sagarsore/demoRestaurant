package com.task.Rudolf.task.service;


import com.task.Rudolf.task.Exception.InvalidTokenException;
import com.task.Rudolf.task.Exception.UserAlreadyExistException;
import com.task.Rudolf.task.web.data.UserData;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    boolean verifyUser(final String username, final String password);
//    UserEntity getUserById(final String id) throws UnkownIdentifierException;
}
