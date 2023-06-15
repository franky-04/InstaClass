package com.instaclass.instituteservice.dto;

import com.instaclass.instituteservice.entity.Institute;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class SubjectDto {
    private Long id;
    private String name;
    private String description;
    private Long institute_id;
}
