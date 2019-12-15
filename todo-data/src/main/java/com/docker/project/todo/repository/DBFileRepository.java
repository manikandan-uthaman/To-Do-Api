package com.docker.project.todo.repository;

import com.docker.project.todo.entity.DBFileBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFileBO, String> {
}
