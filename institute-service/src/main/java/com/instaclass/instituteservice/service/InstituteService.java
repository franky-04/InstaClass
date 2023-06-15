package com.instaclass.instituteservice.service;


import com.instaclass.instituteservice.dto.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.dto.GetInstituteDto;
import com.instaclass.instituteservice.entity.Institute;


public interface InstituteService {
    Institute saveInstitute(Institute institute);

    GetInstituteAndSubjectsDTO getInstituteByIdAndSubjects(Long id);

    GetInstituteDto getInstituteById(Long id);


}
