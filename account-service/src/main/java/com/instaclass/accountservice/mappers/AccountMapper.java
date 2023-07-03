package com.instaclass.accountservice.mappers;

import com.instaclass.accountservice.DTO.AccountDTO.GetAccountDTO;
import com.instaclass.accountservice.DTO.AccountDTO.PostAccountDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.GetAccountInstituteDTO;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.PostAccountInstituteDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.GetRequestJoinInstituteDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.PostRequestJoinInstituteDTO;
import com.instaclass.accountservice.Entity.Account;
import com.instaclass.accountservice.Entity.AccountInstitute;
import com.instaclass.accountservice.Entity.RequestJoinInstitute;

import java.time.LocalDateTime;

public class AccountMapper {


    public static Account mapPostAccountDTOtoAccount(PostAccountDTO postAccountDTO){
        return new Account(
                postAccountDTO.getName(),
                postAccountDTO.getLastName(),
                postAccountDTO.getUsername(),
                postAccountDTO.getPassword(),
                postAccountDTO.getDateOfBirth(),
                postAccountDTO.getEmail()
        );
    }

    public static GetAccountDTO mapAccountToGetAccountDTO(Account account){
        return new GetAccountDTO(
                account.getId(),
                account.getName(),
                account.getLastName(),
                account.getDateOfBirth(),
                account.getUsername(),
                account.getEmail(),
                account.getCreatedAt(),
                account.getLastUpdate(),
                null
                ,null
        );
    }

    public static  GetAccountInstituteDTO mapAccountInstituteToGetAccountInstituteDTO(AccountInstitute accountInstitute) {
        return new GetAccountInstituteDTO(
                accountInstitute.getId(),
                accountInstitute.getInstituteId(),
                accountInstitute.getAccount().getId(),
                accountInstitute.getRole(),
                LocalDateTime.now(),
                null
        );

    }

    public static AccountInstitute mapPostAccountInstituteDTOtoAccountInstitute(PostAccountInstituteDTO postAccountInstituteDTO) {
        AccountInstitute accountInstitute = new AccountInstitute();
        accountInstitute.setInstituteId(postAccountInstituteDTO.getInstitute_id());
        accountInstitute.setAccount(null);
        accountInstitute.setRole(postAccountInstituteDTO.getRole());
        return accountInstitute;
    }

    public static RequestJoinInstitute mapPostRequestJoinInstituteDTOtoRequestJoinInstitute(PostRequestJoinInstituteDTO requestJoinInstituteDTO) {
        RequestJoinInstitute requestJoinInstitute = new RequestJoinInstitute();
        requestJoinInstitute.setInstitute_id(requestJoinInstituteDTO.getInstitute_id());
        requestJoinInstitute.setStatus(requestJoinInstituteDTO.getStatus());
        requestJoinInstitute.setRole(requestJoinInstituteDTO.getRole());
        requestJoinInstitute.setAccount(null);
        return  requestJoinInstitute;
    }

    public static GetRequestJoinInstituteDTO mapRequestJoinInstituteToGetRequestJoinInstituteDTO(RequestJoinInstitute savedRequestJoinInstitute) {
       return new GetRequestJoinInstituteDTO(
               savedRequestJoinInstitute.getId(),
               savedRequestJoinInstitute.getInstitute_id(),
               savedRequestJoinInstitute.getAccount().getId(),
               savedRequestJoinInstitute.getRole(),
               savedRequestJoinInstitute.getStatus(),
               LocalDateTime.now(),
                null
       );
    }

   /* public static GetAccountDTO mapAccountToGetAccountDTO(Account account){
        //recupera gli istituti ai quali è legato l'account
        List<GetAccountInstituteDTO> institutes = new ArrayList<>();


        //recupera le richieste di unirsi agli istituti per quell'account
        List<GetRequestJoinInstituteDTO> requests_join_institutes = new ArrayList<>();
        requests_join_institutes.getSubjects().stream().forEach(s -> getSubjectDto.add(SubjectMapper.mapSubjectToSubjectDTO(s)));
        return new GetAccountDTO(
                account.getId(),
                account.getName(),
                account.getLastName(),
                account.getDateOfBirth(),
                account.getUsername(),
                account.getEmail(),
                account.getCreatedAt(),
                account.getLastUpdate(),
                institutes,
                requests_join_institutes
        );
    }*/

}
