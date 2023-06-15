package com.instaclass.instituteservice.controller;

import com.instaclass.instituteservice.dto.InstituteDto;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.service.InstituteService;
import com.instaclass.instituteservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/institute")
@AllArgsConstructor
public class InstituteController {
    private InstituteService instituteService;
    @PostMapping
    public ResponseEntity<Institute> saveInstitute(@RequestBody Institute institute){
        Institute savedInstitute = instituteService.saveInstitute(institute);
        return new ResponseEntity<>(savedInstitute, HttpStatus.CREATED);
    }
    @GetMapping("{institute-id}")
    public ResponseEntity<Institute> getInstitute(@PathVariable("institute-id") Long id){
        Institute institute = instituteService.getInstituteById(id);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }



}
