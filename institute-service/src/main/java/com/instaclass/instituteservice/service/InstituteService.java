package com.instaclass.instituteservice.service;


import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.PostInstituteDTO;


public interface InstituteService {
    GetInstituteDTO saveInstitute(PostInstituteDTO postInstituteDTO);

    GetInstituteAndSubjectsDTO getInstituteByIdAndSubjects(Long id);

    GetInstituteDTO getInstituteById(Long id);


}
