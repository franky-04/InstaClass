package com.instaclass.instituteservice.DTO.instituteDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInstituteDTO {
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;
    @JsonProperty("account_join_requests")
    private List<AccountJoinRequestsDTO> accountJoinRequests;
    @JsonProperty("institute_accounts")
    private List<InstituteAccountDTO> instituteAccounts;


}
