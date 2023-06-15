package com.instaclass.instituteservice.controller;


import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.entity.Subject;
import com.instaclass.instituteservice.service.InstituteService;
import com.instaclass.instituteservice.service.SubjectService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
        //fare save su subject
        Subject savedSubject = subjectService.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("{subject-id}")
    public ResponseEntity<Subject> getSubject(@PathVariable("subject-id") Long id){
        Subject subject = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

}
