package com.instaclass.instituteservice.DTO.instituteDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("subjects")
    private List<GetSubjectDTO> subjects;

}
