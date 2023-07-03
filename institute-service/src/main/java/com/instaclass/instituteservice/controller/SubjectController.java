package com.instaclass.instituteservice.controller;


import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.instaclass.instituteservice.DTO.subjectDTO.PostSubjectDTO;
import com.instaclass.instituteservice.service.InstituteService;
import com.instaclass.instituteservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;
    private InstituteService instituteService;

    //VEDERE VIDEO
    //chiedere a giuseppe:
      //- perche la get torna l'ogetto ma senza institute_id
    // - perche la save da errore



    //request body
   @PostMapping
    public ResponseEntity<GetSubjectDTO> saveSubject(@RequestBody PostSubjectDTO postSubjectDTO){
        GetSubjectDTO subjectDto = subjectService.saveSubject(postSubjectDTO);
        return new ResponseEntity<>(subjectDto,HttpStatus.CREATED);
    }
    @GetMapping("{subject-id}")
    public ResponseEntity<GetSubjectDTO> getSubject(@PathVariable("subject-id") Long id){
        GetSubjectDTO subjectDto = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subjectDto, HttpStatus.OK);
    }

}
