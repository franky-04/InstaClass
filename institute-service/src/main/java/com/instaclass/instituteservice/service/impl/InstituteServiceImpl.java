package com.instaclass.instituteservice.service.impl;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.repository.InstituteRepository;
import com.instaclass.instituteservice.service.InstituteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private InstituteRepository instituteRepository;

    @Override
    public Institute saveInstitute(Institute institute) {
        return instituteRepository.save(institute);

    }

    @Override
    public Institute getInstituteById(Long id) {
        return instituteRepository.findInstituteById(id);
    }



}
