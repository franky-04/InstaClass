package com.instaclass.instituteservice.mappers;

import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.GetInstituteDTO;
import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.PostInstituteDTO;
import com.instaclass.instituteservice.entity.Institute;

import java.util.ArrayList;
import java.util.List;

public class InstituteMapper {

    public static GetInstituteDTO mapInstituteToGetInstituteDTO(Institute institute){
        return new GetInstituteDTO(
                institute.getId(),
                institute.getName(),
                institute.getAddress(),
                institute.getDescription(),
                institute.getCreatedAt(),
                institute.getLastUpdate(),
                null,
                null
        );
    }

    public static GetInstituteAndSubjectsDTO mapInstituteToGetInstituteAndSubjectsDTO(Institute institute){
        List<GetSubjectDTO> subjects = new ArrayList<>();
        institute.getSubjects().forEach(s -> subjects.add(SubjectMapper.mapSubjectToSubjectDTO(s)));
        return new GetInstituteAndSubjectsDTO(
                institute.getId(),
                institute.getName(),
                institute.getAddress(),
                institute.getDescription(),
                institute.getCreatedAt(),
                institute.getLastUpdate(),
                subjects
        );
    }


    public static Institute postInstituteDTOtoInstitute(PostInstituteDTO postInstituteDTO) {
        return new Institute(
                postInstituteDTO.getName(),
                postInstituteDTO.getAddress(),
                postInstituteDTO.getDescription()
        );
    }
}
