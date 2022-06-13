package com.recruitment.repository;

import com.recruitment.entity.TaskEntity;
import com.recruitment.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByUser(UserEntity user);

}
