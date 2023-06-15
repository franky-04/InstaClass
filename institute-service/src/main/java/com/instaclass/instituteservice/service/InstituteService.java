package com.instaclass.instituteservice.service;


import com.instaclass.instituteservice.entity.Institute;


public interface InstituteService {
    Institute saveInstitute(Institute institute);
    Institute getInstituteById(Long id);


}
