package com.instaclass.accountservice.service;

import com.instaclass.accountservice.DTO.AccountDTO.GetAccountDTO;
import com.instaclass.accountservice.DTO.AccountDTO.PostAccountDTO;
import com.instaclass.accountservice.DTO.JoinDTO.AccountJoinRequestsDTO;
import com.instaclass.accountservice.DTO.JoinDTO.InstituteAccountDTO;

import java.util.List;

public interface AccountService {
    GetAccountDTO saveAccount(PostAccountDTO postAccountDTO);
    GetAccountDTO getAccountById(Long id);

    //recupera tutte le richieste per un account di unirsi a un istituto dato l'id dell'istituto
    List<AccountJoinRequestsDTO>  getAllAccountRequestsToJoinInstitute(Long id);


    //recupera tutti gli account collegati a un instituto dato l'id dell'stituto
    List<InstituteAccountDTO> getAllInstituteAccounts(Long id);


    /*//recupera tutte le richieste ricevuto da un account di unirsi ad un istituto dato l'account id
    List<AccountJoinRequestsDTO>  getAllAccountRequestsToJoinInstituteByAccountId(Long id);


    //recupera tutti i collegamenti di un account verso gli istituti dato account id
    List<InstituteAccountDTO> getAllInstituteAccountsByAccountId(Long id);*/


}
