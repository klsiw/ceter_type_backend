package com.example.centertypemanagement.controllers;

import com.example.centertypemanagement.models.CenterType;
import com.example.centertypemanagement.services.CenterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center_management")
public class CenterTypeController {

    @Autowired
    CenterTypeService centerTypeService;

    @GetMapping("/find_all")
    public List<CenterType> findAll(){
        return centerTypeService.findAll();
    }

    @GetMapping("/find_by_id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        CenterType centerType = centerTypeService.findById(id);
        if(centerType!=null){
            return ResponseEntity.ok().body(centerType);
        }else{
            return ResponseEntity.badRequest().body("Record not exists with primary key "+id);
        }
    }

    @PostMapping("/create_new_center_type")
    public ResponseEntity<?> addNewCenterType(@RequestBody CenterType centerType){
        String response = centerTypeService.addNewCenterType(centerType);
        String result = response.split(":")[0].trim();
        if(result.equals("success")){
            return ResponseEntity.ok().body(result);
        }else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/update_center_type")
    public ResponseEntity<?> updateCenterType(@RequestBody CenterType centerType){
        String response = centerTypeService.updateCenterType(centerType);
        String result = response.split(":")[0].trim();
        if(result.equals("success")){
            return ResponseEntity.ok().body(result);
        }else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/delete_certificate_type")
    public ResponseEntity<?> deleteCenterType(@RequestBody CenterType centerType){
        String response = centerTypeService.deleteCenterType(centerType);
        String result = response.split(":")[0].trim();
        if(result.equals("success")){
            return ResponseEntity.ok().body(result);
        }else{
            return ResponseEntity.badRequest().body(result);
        }
    }

}
