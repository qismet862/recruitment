package com.recruitment.repository;

import com.recruitment.entity.AdminTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminTokenRepository extends JpaRepository<AdminTokenEntity, String> {
}
