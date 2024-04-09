package com.bloom.service.implementations;

import com.bloom.dto.user.RegisterUserDto;
import com.bloom.exception.UserAlreadyExistsException;
import com.bloom.models.Role;
import com.bloom.models.User;
import com.bloom.repository.RoleRepository;
import com.bloom.repository.UserRepository;
import com.bloom.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerNewUser(RegisterUserDto registerUserDto) throws UserAlreadyExistsException {

        if (emailExists(registerUserDto.getEmailAddress())) {
            throw new UserAlreadyExistsException("There is an account with that email address" +
                    registerUserDto.getEmailAddress());
        }

        // TODO Set avatar path to a randomly selected image from a predefined collection
        // TODO I'll need another constructor for this
        // TODO EmailAlreadyExitsException
        // TODO UsernameAlreadyExistsException
        // TODO Create UTIL Classes for defaultRoles, Username, Email Exist
        User user = new User(
                registerUserDto.getEmailAddress(),
                registerUserDto.getDisplayName(),
                registerUserDto.getUsername(),
                passwordEncoder.encode(registerUserDto.getPassword()),
                registerUserDto.getDateOfBirth(),
                defaultRoles()
        );

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmailAddress(email) != null;
    }

    private Set<Role> defaultRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user"));
        return roles;
    }
}
