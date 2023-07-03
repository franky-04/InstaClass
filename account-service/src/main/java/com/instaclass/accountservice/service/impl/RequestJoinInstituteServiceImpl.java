package com.instaclass.accountservice.service.impl;

import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.GetRequestJoinInstituteDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.PostRequestJoinInstituteDTO;
import com.instaclass.accountservice.Entity.Account;
import com.instaclass.accountservice.Entity.RequestJoinInstitute;
import com.instaclass.accountservice.mappers.AccountMapper;
import com.instaclass.accountservice.repository.RequestJoinInstituteRepository;
import com.instaclass.accountservice.service.RequestJoinInstituteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestJoinInstituteServiceImpl implements RequestJoinInstituteService {
    private AccountServiceImpl accountService;
    private RequestJoinInstituteRepository requestJoinInstituteRepository;

    @Override
    public GetRequestJoinInstituteDTO saveRequest(PostRequestJoinInstituteDTO requestJoinInstituteDTO) {
        Account account = accountService.getAccountByIdInternalUse(requestJoinInstituteDTO.getAccount_id());

        RequestJoinInstitute requestJoinInstitute = AccountMapper.mapPostRequestJoinInstituteDTOtoRequestJoinInstitute(requestJoinInstituteDTO);
        requestJoinInstitute.setAccount(account);
        RequestJoinInstitute savedRequestJoinInstitute = requestJoinInstituteRepository.save(requestJoinInstitute);
        return AccountMapper.mapRequestJoinInstituteToGetRequestJoinInstituteDTO(savedRequestJoinInstitute);

    }
}
