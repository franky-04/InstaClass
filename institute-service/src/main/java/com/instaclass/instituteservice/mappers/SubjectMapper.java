package com.instaclass.instituteservice.mappers;

import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.instaclass.instituteservice.entity.Subject;

import lombok.Data;

@Data
public class SubjectMapper {


    public static GetSubjectDTO mapSubjectToSubjectDTO(Subject subject){
        return new GetSubjectDTO(
                subject.getId(),
                subject.getName(),
                subject.getDescription(),
                subject.getCreatedAt(),
                subject.getLastUpdate()
        );
    }


    //ELIMINARE
    /*public static GetSubjectAndInstituteDTO mapSubjectAndInstituteToSubjectAndInstituteDTO(Institute institute,Subject subject){
        return new GetSubjectAndInstituteDTO(
                subject.getId(),
                subject.getName(),
                subject.getDescription(),
                subject.getInstitute()
        );
    }*/




}
