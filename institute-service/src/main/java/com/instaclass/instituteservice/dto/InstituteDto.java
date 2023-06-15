package com.instaclass.instituteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDto {
    private Long id;
    private String name;
    private String address;
    private String description;

}
