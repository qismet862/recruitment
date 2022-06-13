package com.recruitment.repository;

import com.recruitment.entity.AdminEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByUserName(String userName);

}
