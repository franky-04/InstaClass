package com.instaclass.instituteservice.controller;

import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.PostInstituteDTO;
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
    public ResponseEntity<GetInstituteDTO> saveInstitute(@RequestBody PostInstituteDTO postInstituteDTO){
        GetInstituteDTO instituteDto = instituteService.saveInstitute(postInstituteDTO);
        return new ResponseEntity<>(instituteDto, HttpStatus.CREATED);
    }

    //ritorna solo institute
    @GetMapping("{institute-id}")
    public ResponseEntity<GetInstituteDTO> getInstitute(@PathVariable("institute-id") Long id){
        GetInstituteDTO instituteDto = instituteService.getInstituteById(id);
        return new ResponseEntity<>(instituteDto, HttpStatus.OK);
    }

    //ritorna instituto con tutte le sue materie
    @GetMapping("subjects/{institute-id}")
    public ResponseEntity<GetInstituteAndSubjectsDTO> getInstituteAndSubjects(@PathVariable("institute-id") Long id){
        GetInstituteAndSubjectsDTO instituteAndSubjectsDTO = instituteService.getInstituteByIdAndSubjects(id);
        return new ResponseEntity<>(instituteAndSubjectsDTO, HttpStatus.OK);
    }



}
