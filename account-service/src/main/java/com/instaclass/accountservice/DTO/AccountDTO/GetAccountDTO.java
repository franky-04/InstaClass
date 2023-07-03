package com.instaclass.accountservice.DTO.AccountDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.instaclass.accountservice.DTO.AccountInstituteDTO.GetAccountInstituteDTO;
import com.instaclass.accountservice.DTO.JoinDTO.AccountJoinRequestsDTO;
import com.instaclass.accountservice.DTO.RequestJoinInstituteDTO.GetRequestJoinInstituteDTO;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("account_institute")
    private List<GetAccountInstituteDTO> accountInstitutes;

    @JsonProperty("account_join_request")
    private List<AccountJoinRequestsDTO> accountJoinRequests;


}
