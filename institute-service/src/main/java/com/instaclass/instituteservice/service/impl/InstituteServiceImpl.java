package com.instaclass.instituteservice.service.impl;
import com.instaclass.instituteservice.dto.GetInstituteAndSubjectsDTO;
import com.instaclass.instituteservice.dto.GetInstituteDto;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.mappers.InstituteMapper;
import com.instaclass.instituteservice.repository.InstituteRepository;
import com.instaclass.instituteservice.service.InstituteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.instaclass.instituteservice.mappers.InstituteMapper.mapInstituteToGetInstituteDTO;


@Service
@AllArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private InstituteRepository instituteRepository;

    @Override
    public Institute saveInstitute(Institute institute) {
        return instituteRepository.save(institute);

    }

    public GetInstituteDto getInstituteById(Long id) {
        Institute institute = instituteRepository.findInstituteById(id);
        return mapInstituteToGetInstituteDTO(institute);
    }

   @Override
    public GetInstituteAndSubjectsDTO getInstituteByIdAndSubjects(Long id) {
        return InstituteMapper.mapInstituteToGetInstituteAndSubjectsDTO(instituteRepository.findInstituteById(id));
    }



}
