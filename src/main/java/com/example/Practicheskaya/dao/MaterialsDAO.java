package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsDAO extends JpaRepository<Material, Long> {
}
