package com.instaclass.accountservice.DTO.AccountInstituteDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountInstituteDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("institute_id")
    private Long institute_id;

    @JsonProperty("account_id")
    private Long account_id;

    @JsonProperty("role")
    @NotNull
    private String role;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;
}
