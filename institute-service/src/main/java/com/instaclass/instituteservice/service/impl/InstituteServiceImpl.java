package com.instaclass.instituteservice.service.impl;
import com.instaclass.instituteservice.DTO.instituteDTO.*;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.mappers.InstituteMapper;
import com.instaclass.instituteservice.repository.InstituteRepository;
import com.instaclass.instituteservice.service.APIClient;
import com.instaclass.instituteservice.service.InstituteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private InstituteRepository instituteRepository;
    private APIClient apiClient;

    @Override
    public GetInstituteDTO saveInstitute(PostInstituteDTO postInstituteDTO) {
        Institute institute = instituteRepository.save(InstituteMapper.postInstituteDTOtoInstitute(postInstituteDTO));
        return InstituteMapper.mapInstituteToGetInstituteDTO(institute);
    }

    public GetInstituteDTO getInstituteById(Long id) {
        List<AccountJoinRequestsDTO> accountJoinRequests = apiClient.getAllAccountJoinRequests(id);
        List<InstituteAccountDTO> instituteAccounts = apiClient.getAllInstituteAccounts(id);
        GetInstituteDTO getInstituteDTO = InstituteMapper.mapInstituteToGetInstituteDTO(instituteRepository.findInstituteById(id));
        getInstituteDTO.setAccountJoinRequests(accountJoinRequests);
        getInstituteDTO.setInstituteAccounts(instituteAccounts);
        return getInstituteDTO;
    }

   @Override
    public GetInstituteAndSubjectsDTO getInstituteByIdAndSubjects(Long id) {
        return InstituteMapper.mapInstituteToGetInstituteAndSubjectsDTO(instituteRepository.findInstituteById(id));
    }



}
