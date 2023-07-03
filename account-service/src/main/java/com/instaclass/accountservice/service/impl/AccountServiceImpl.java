package com.instaclass.accountservice.service.impl;

import com.instaclass.accountservice.DTO.AccountDTO.GetAccountDTO;
import com.instaclass.accountservice.DTO.AccountDTO.PostAccountDTO;
import com.instaclass.accountservice.DTO.JoinDTO.AccountJoinRequestsDTO;
import com.instaclass.accountservice.DTO.JoinDTO.InstituteAccountDTO;
import com.instaclass.accountservice.Entity.Account;
import com.instaclass.accountservice.mappers.AccountMapper;
import com.instaclass.accountservice.repository.AccountInstituteRepository;
import com.instaclass.accountservice.repository.AccountRepository;
import com.instaclass.accountservice.repository.RequestJoinInstituteRepository;
import com.instaclass.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private RequestJoinInstituteRepository requestJoinInstituteRepository;

    private AccountInstituteRepository accountInstituteRepository;


    @Override
    public GetAccountDTO saveAccount(PostAccountDTO postAccountDTO) {
        return AccountMapper.mapAccountToGetAccountDTO(accountRepository.save(AccountMapper.mapPostAccountDTOtoAccount(postAccountDTO)));
    }


    public GetAccountDTO getAccountById(Long id) {
       return AccountMapper.mapAccountToGetAccountDTO(accountRepository.findAccountById(id));
    }

    @Override
    public List<AccountJoinRequestsDTO> getAllAccountRequestsToJoinInstitute(Long id) {
        String[][] accountRequestsArray = requestJoinInstituteRepository.getAllAccountRequestsToJoinInstitute(id);
        List<AccountJoinRequestsDTO> accountJoinRequests = new ArrayList<>();
        for (String[] strings : accountRequestsArray) {
            AccountJoinRequestsDTO accountJoinRequest = new AccountJoinRequestsDTO();
            accountJoinRequest.setInstitute_id(parseLong(strings[0]));
            accountJoinRequest.setAccount_id(parseLong(strings[1]));
            accountJoinRequest.setRole((strings[2]));
            accountJoinRequest.setStatus((strings[3]));
            accountJoinRequest.setName((strings[4]));
            accountJoinRequest.setLast_name((strings[5]));
            accountJoinRequest.setEmail((strings[6]));

            accountJoinRequests.add(accountJoinRequest);
        }

        return accountJoinRequests;
    }

    @Override
    public List<InstituteAccountDTO> getAllInstituteAccounts(Long id) {

        String[][] instituteAccountsArray = accountInstituteRepository.getAllInstituteAccounts(id);
        List<InstituteAccountDTO> instituteAccounts = new ArrayList<>();
        for (String[] strings : instituteAccountsArray) {
            InstituteAccountDTO instituteAccountsDTO = new InstituteAccountDTO();
            instituteAccountsDTO.setInstitute_id(parseLong(strings[0]));
            instituteAccountsDTO.setAccount_id(parseLong(strings[1]));
            instituteAccountsDTO.setRole((strings[2]));
            instituteAccountsDTO.setName((strings[4]));
            instituteAccountsDTO.setLast_name((strings[5]));
            instituteAccountsDTO.setEmail((strings[6]));

            instituteAccounts.add(instituteAccountsDTO);
        }

        return instituteAccounts;
    }


    //recupera solo Account, per uso interno
    public Account getAccountByIdInternalUse(Long id) {
        return accountRepository.findAccountById(id);
    }


}
