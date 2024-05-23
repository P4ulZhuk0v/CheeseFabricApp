package com.example.Practicheskaya.service;

import com.example.Practicheskaya.dao.MaterialsDAO;
import com.example.Practicheskaya.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsService {

    private final MaterialsDAO materialsDAO;

    public MaterialsService(MaterialsDAO materialsDAO) {
        this.materialsDAO = materialsDAO;
    }

    public void save(Material material) {
        Material newmaterial = materialsDAO.save(material);
    }

    public List<Material> getAllMaterials() {
        List<Material> list = materialsDAO.findAll();
        return list;
    }
}
