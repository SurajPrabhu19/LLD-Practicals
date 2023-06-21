package com.scaler.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.splitwise.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findUserById(Long id);
}
