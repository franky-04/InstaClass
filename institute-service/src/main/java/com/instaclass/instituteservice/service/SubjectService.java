package com.instaclass.instituteservice.service;

import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.instaclass.instituteservice.DTO.subjectDTO.PostSubjectDTO;

public interface SubjectService {
    GetSubjectDTO saveSubject(PostSubjectDTO postSubjectDTO);

    GetSubjectDTO getSubjectById(Long id);

   // GetSubjectAndInstituteDTO getSubjectAndInstituteById(Long id);
}
