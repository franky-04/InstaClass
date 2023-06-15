package com.instaclass.instituteservice.mappers;

import com.instaclass.instituteservice.dto.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.dto.GetInstituteDto;
import com.instaclass.instituteservice.dto.GetSubjectDto;
import com.instaclass.instituteservice.entity.Institute;

import java.util.ArrayList;
import java.util.List;

public class InstituteMapper {

    public static GetInstituteDto mapInstituteToGetInstituteDTO(Institute institute){
        return new GetInstituteDto(
                institute.getId(),
                institute.getName(),
                institute.getAddress(),
                institute.getDescription()
        );
    }

    public static GetInstituteAndSubjectsDTO mapInstituteToGetInstituteAndSubjectsDTO(Institute institute){
        List<GetSubjectDto> getSubjectDto = new ArrayList<>();
        institute.getSubjects().stream().forEach(s -> getSubjectDto.add(SubjectMapper.mapSubjectToSubjectToDTO(s)));
        return new GetInstituteAndSubjectsDTO(
                institute.getId(),
                institute.getName(),
                institute.getAddress(),
                institute.getDescription(),
                getSubjectDto
        );
    }





}
