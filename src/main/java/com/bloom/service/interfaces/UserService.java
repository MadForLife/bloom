package com.bloom.service.interfaces;

import com.bloom.dto.user.RegisterUserDto;
import com.bloom.exception.UserAlreadyExistsException;
import com.bloom.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    User findByUsername(String username);
    User findByEmailAddress(String emailAddress);
    User save(User user);
    User registerNewUser(RegisterUserDto registerUserDto) throws UserAlreadyExistsException;

}
