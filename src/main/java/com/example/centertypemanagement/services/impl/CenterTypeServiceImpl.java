package com.example.centertypemanagement.services.impl;

import com.example.centertypemanagement.models.CenterType;
import com.example.centertypemanagement.repository.CenterTypeRepository;
import com.example.centertypemanagement.services.CenterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.Certificate;
import java.util.List;

@Service
public class CenterTypeServiceImpl implements CenterTypeService {

    @Autowired
    CenterTypeRepository centerTypeRepository;

    @Override
    public List<CenterType> findAll() {
        return centerTypeRepository.findAll();
    }

    @Override
    public CenterType findById(Integer id) {

        //centerTypeRepository.findById(id);
        //This return value is java optional

        //Optional is a better way to handle exception
        //In order to optional value
        //We can use orElse() , orElseThrow()

        CenterType centerType = centerTypeRepository.findById(id).orElse(null);
        return centerType;
    }

    @Override
    public String addNewCenterType(CenterType centerType) {
        try{
            if(!centerTypeRepository.existsById(centerType.getCenterTypeId())){
                centerTypeRepository.save(centerType);
                return "success : New Record added successfully!";
            }else{
                return "error : Record already exists with provided primary key combination!";
            }
        }catch (Exception e){
            return "error : " + e.getLocalizedMessage();
        }
    }

    @Override
    public String updateCenterType(CenterType centerType) {
        try{
            if(centerTypeRepository.existsById(centerType.getCenterTypeId())){
                centerTypeRepository.save(centerType);
                return "success : Record updated successfully!";
            }else{
                return "error : Record not exists with provided primary key combination!";
            }
        }catch (Exception e){
            return "error : " + e.getLocalizedMessage();
        }
    }

    @Override
    public String deleteCenterType(CenterType centerType) {
        try{
            if(centerTypeRepository.existsById(centerType.getCenterTypeId())){
                centerTypeRepository.delete(centerType);
                return "success : Record deleted successfully!";
            }else{
                return "error : Record not exists with provided primary key combination!";
            }
        }catch (Exception e){
            return "error : " + e.getLocalizedMessage();
        }
    }


}
