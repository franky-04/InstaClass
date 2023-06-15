package com.instaclass.instituteservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.instaclass.instituteservice.entity.Subject;
import com.sun.istack.NotNull;

import java.util.List;
import java.util.Set;

public class PostInstituteDTO {

    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("subjects")
    private List<Subject> subjects;

}
