package com.instaclass.instituteservice.mappers;

import com.instaclass.instituteservice.dto.GetInstituteDto;
import com.instaclass.instituteservice.dto.GetSubjectDto;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.entity.Subject;

public class SubjectMapper {

    public static GetSubjectDto mapSubjectToSubjectToDTO(Subject subject){
        return new GetSubjectDto(
                subject.getId(),
                subject.getName(),
                subject.getDescription()
        );
    }

}
