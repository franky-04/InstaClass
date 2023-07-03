package com.instaclass.instituteservice.service;


import com.instaclass.instituteservice.DTO.instituteDTO.AccountJoinRequestsDTO;
import com.instaclass.instituteservice.DTO.instituteDTO.InstituteAccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url="http://localhost:8082", value="ACCOUNT-SERVICE")
public interface APIClient {
    @GetMapping("api/account/account-join-requests/{institute-id}")
    public List<AccountJoinRequestsDTO> getAllAccountJoinRequests(@PathVariable("institute-id") Long id);

    @GetMapping("api/account/institute-accounts/{institute-id}")
    public List<InstituteAccountDTO> getAllInstituteAccounts(@PathVariable("institute-id") Long id);
}
