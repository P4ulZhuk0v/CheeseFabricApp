package com.example.Practicheskaya.service;

import com.example.Practicheskaya.dao.MaterialsDAO;
import com.example.Practicheskaya.entity.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialsService {

    private final MaterialsDAO materialsDAO;

    public void save(Material material) {
        Material newmaterial = materialsDAO.save(material);
    }

    public List<Material> getAllMaterials() {
        List<Material> list = materialsDAO.findAll();
        return list;
    }
}
