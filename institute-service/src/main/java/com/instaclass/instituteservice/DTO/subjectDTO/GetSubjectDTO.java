package com.instaclass.instituteservice.DTO.subjectDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class GetSubjectDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;


}
