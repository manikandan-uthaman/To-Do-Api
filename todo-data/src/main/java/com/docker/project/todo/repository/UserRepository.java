package com.docker.project.todo.repository;

import com.docker.project.todo.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserBO, Long> {
    Optional<UserBO> findByEmail(String email);

    Optional<UserBO> findByUsernameOrEmail(String username, String email);

    List<UserBO> findByIdIn(List<Long> userIds);

    Optional<UserBO> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
