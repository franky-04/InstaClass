package com.instaclass.instituteservice.DTO.instituteDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteAccountDTO {

    Long institute_id;
    Long account_id;
    String role;
    String name;
    String last_name;
    String username;
    String email;

}
