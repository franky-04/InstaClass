package com.instaclass.accountservice.service;

import com.instaclass.accountservice.DTO.AccountInstituteDTO.GetAccountInstituteDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.PostAccountInstituteDTO;

import java.util.List;

public interface AccountInstituteService {

    GetAccountInstituteDTO saveAccountInstitute(PostAccountInstituteDTO postAccountInstituteDTO);

}
