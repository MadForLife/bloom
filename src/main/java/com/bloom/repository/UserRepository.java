package com.bloom.repository;

import com.bloom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    User findByUsername(String username);
    User findByEmailAddress(String emailAddress);
    User save(User user);

}
