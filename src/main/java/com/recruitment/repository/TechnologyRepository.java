package com.recruitment.repository;

import com.recruitment.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

}
