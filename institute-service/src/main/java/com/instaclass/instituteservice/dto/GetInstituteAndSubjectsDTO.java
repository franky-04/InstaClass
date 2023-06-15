package com.instaclass.instituteservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.instaclass.instituteservice.entity.Subject;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class GetInstituteAndSubjectsDTO {
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    private String address;
    @JsonProperty("description")
    private String description;

    @JsonProperty("subjects")
    private List<GetSubjectDto> subjects;
}
