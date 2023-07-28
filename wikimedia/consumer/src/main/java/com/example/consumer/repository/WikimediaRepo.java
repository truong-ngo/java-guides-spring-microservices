package com.example.consumer.repository;

import com.example.consumer.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepo extends JpaRepository<Wikimedia, Long> {
}
