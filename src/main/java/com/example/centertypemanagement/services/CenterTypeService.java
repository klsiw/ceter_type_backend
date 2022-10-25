package com.example.centertypemanagement.services;

import com.example.centertypemanagement.models.CenterType;
import java.util.List;

public interface CenterTypeService {
    List<CenterType> findAll();
    CenterType findById(Integer id);
    String addNewCenterType(CenterType centerType);
    String updateCenterType(CenterType centerType);
    String deleteCenterType(CenterType centerType);

}
