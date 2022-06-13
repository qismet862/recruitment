package com.recruitment.repository;

import com.recruitment.entity.NotificationEntity;
import com.recruitment.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByUser(UserEntity user);
}
