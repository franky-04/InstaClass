package com.instaclass.instituteservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.instaclass.instituteservice.entity.Institute;
import com.sun.istack.NotNull;

public class GetSubjectAndInstituteDTO {
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("institute")
    private Institute institute;
}