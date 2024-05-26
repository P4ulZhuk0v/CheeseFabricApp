package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialsDAO extends JpaRepository<Material, Long> {
    List<Material> findAllByNameOrderById(String name);
}
