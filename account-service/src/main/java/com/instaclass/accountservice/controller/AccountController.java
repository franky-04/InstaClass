package com.instaclass.accountservice.controller;

import com.instaclass.accountservice.DTO.AccountDTO.GetAccountDTO;
import com.instaclass.accountservice.DTO.AccountDTO.PostAccountDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.GetAccountInstituteDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.PostAccountInstituteDTO;
import com.instaclass.accountservice.DTO.JoinDTO.AccountJoinRequestsDTO;
import com.instaclass.accountservice.DTO.JoinDTO.InstituteAccountDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.GetRequestJoinInstituteDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.PostRequestJoinInstituteDTO;
import com.instaclass.accountservice.repository.RequestJoinInstituteRepository;
import com.instaclass.accountservice.service.AccountInstituteService;
import com.instaclass.accountservice.service.AccountService;
import com.instaclass.accountservice.service.RequestJoinInstituteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    private AccountInstituteService accountInstituteService;
    private RequestJoinInstituteService requestJoinInstituteService;


    @PostMapping()
    public ResponseEntity<GetAccountDTO> saveAccount(@RequestBody PostAccountDTO postAccountDTO) {
        GetAccountDTO accountDTO = accountService.saveAccount(postAccountDTO);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }


    @GetMapping("{account-id}")
    public ResponseEntity<GetAccountDTO> getAccount(@PathVariable("account-id") Long id) {
        GetAccountDTO accountDTO = accountService.getAccountById(id);
        return new ResponseEntity<GetAccountDTO>(accountDTO, HttpStatus.OK);
    }

    @PostMapping("/account-institute")
    public ResponseEntity<GetAccountInstituteDTO> saveAccountInstitute(@RequestBody PostAccountInstituteDTO postAccountInstituteDTO) {
        GetAccountInstituteDTO accountInstituteDTO = accountInstituteService.saveAccountInstitute(postAccountInstituteDTO);
        return new ResponseEntity<>(accountInstituteDTO, HttpStatus.CREATED);
    }

    @PostMapping("/account-requests")
    public ResponseEntity<GetRequestJoinInstituteDTO> saveAccountRequestsJoinInstitute(@RequestBody PostRequestJoinInstituteDTO postRequestJoinInstituteDTO) {
        GetRequestJoinInstituteDTO requestJoinInstituteDTO = requestJoinInstituteService.saveRequest(postRequestJoinInstituteDTO);
        return new ResponseEntity<>(requestJoinInstituteDTO, HttpStatus.CREATED);
    }


    //ritorna una lista risultato di join tra account e request_join_account,
    // filtrate per institute id_
    @GetMapping("/account-join-requests/{institute-id}")
    public ResponseEntity<List<AccountJoinRequestsDTO>> getAllAccountJoinRequests(@PathVariable("institute-id") Long id) {
        List<AccountJoinRequestsDTO> listOfRequests = accountService.getAllAccountRequestsToJoinInstitute(id);
        return new ResponseEntity<>(listOfRequests, HttpStatus.OK);
    }

    //ritorna una lista risultato di join tra account e account_institute,
    // filtrate per institute id_
    @GetMapping("/institute-accounts/{institute-id}")
    public ResponseEntity<List<InstituteAccountDTO>> getAllInstituteAccounts(@PathVariable("institute-id") Long id) {
        List<InstituteAccountDTO> instituteAccounts = accountService.getAllInstituteAccounts(id);
        return new ResponseEntity<>(instituteAccounts, HttpStatus.OK);
    }


}
