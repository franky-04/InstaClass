package com.instaclass.instituteservice.controller;

import com.instaclass.instituteservice.dto.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.dto.GetInstituteDto;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.service.InstituteService;
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

    //ritorna solo institute
    @GetMapping("{institute-id}")
    public ResponseEntity<GetInstituteDto> getInstitute(@PathVariable("institute-id") Long id){
        GetInstituteDto instituteDto = instituteService.getInstituteById(id);
        return new ResponseEntity<>(instituteDto, HttpStatus.OK);
    }

    //ritorna instituto con tutte le sue materie
    @GetMapping("subjects/{institute-id}")
    public ResponseEntity<GetInstituteAndSubjectsDTO> getInstituteAndSubjects(@PathVariable("institute-id") Long id){
        GetInstituteAndSubjectsDTO instituteAndSubjectsDTO = instituteService.getInstituteByIdAndSubjects(id);
        return new ResponseEntity<>(instituteAndSubjectsDTO, HttpStatus.OK);
    }



}
