package com.instaclass.accountservice.service.impl;

import com.instaclass.accountservice.DTO.AccountInstituteDTO.GetAccountInstituteDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.PostAccountInstituteDTO;
import com.instaclass.accountservice.Entity.Account;
import com.instaclass.accountservice.Entity.AccountInstitute;
import com.instaclass.accountservice.mappers.AccountMapper;
import com.instaclass.accountservice.repository.AccountInstituteRepository;
import com.instaclass.accountservice.service.AccountInstituteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.Long.parseLong;

@Service
@AllArgsConstructor
public class AccountInstituteServiceImpl implements AccountInstituteService {
    private AccountInstituteRepository accountInstituteRepository;
    private AccountServiceImpl accountService;

    @Override
    public GetAccountInstituteDTO saveAccountInstitute(PostAccountInstituteDTO postAccountInstituteDTO) {
        Account account = accountService.getAccountByIdInternalUse(postAccountInstituteDTO.getAccount_id());

        AccountInstitute accountInstitute = AccountMapper.mapPostAccountInstituteDTOtoAccountInstitute(postAccountInstituteDTO);
        accountInstitute.setAccount(account);
        AccountInstitute savedAccountInstitute = accountInstituteRepository.save(accountInstitute);
        return AccountMapper.mapAccountInstituteToGetAccountInstituteDTO(savedAccountInstitute);
    }

}
