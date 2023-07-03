package com.instaclass.instituteservice.DTO.instituteDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostInstituteDTO {

    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    private String address;

    @JsonProperty("description")
    private String description;

}
