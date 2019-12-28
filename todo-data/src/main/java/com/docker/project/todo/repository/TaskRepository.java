package com.docker.project.todo.repository;

import com.docker.project.todo.entity.TaskBO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskBO, Integer> {

    List<TaskBO> findAllByUserId(@Param("user_id") Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks t SET t.task_status= ?2 WHERE t.id= ?1 AND  t.user_id = ?3", nativeQuery = true)
    int updateTaskStatus(@Param("taskId") int taskId, @Param("status") String status, @Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tasks t WHERE t.id = ?1 AND t.user_id = ?2", nativeQuery = true)
    void deleteTask(@Param("taskId") int taskId, @Param("userId") Long userId);

}
