package com.docker.project.todo.repository;

import com.docker.project.todo.entity.TaskBO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CrudRepository<TaskBO, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks t SET t.task_status= ?2 WHERE t.id= ?1", nativeQuery = true)
    int updateTaskStatus(@Param("taskId") int taskId, @Param("status") String status);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks t SET t.file_id = ?1 WHERE t.id = ?2", nativeQuery = true)
    int updateFileDetail(String fileId, String taskId);

}
