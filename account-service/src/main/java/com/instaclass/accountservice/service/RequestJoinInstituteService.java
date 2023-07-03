package com.instaclass.accountservice.service;


import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.GetRequestJoinInstituteDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.PostRequestJoinInstituteDTO;

public interface RequestJoinInstituteService {
    GetRequestJoinInstituteDTO saveRequest(PostRequestJoinInstituteDTO requestJoinInstituteDTO);
}
