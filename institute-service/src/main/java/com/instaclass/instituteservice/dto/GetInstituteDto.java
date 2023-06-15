package com.instaclass.instituteservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInstituteDto {
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    private String address;

    @JsonProperty("description")
    private String description;

}
