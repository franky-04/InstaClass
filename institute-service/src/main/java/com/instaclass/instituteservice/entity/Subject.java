package com.instaclass.instituteservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "last_update")
    @LastModifiedDate
    private LocalDateTime lastUpdate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "institute_id",nullable = false)
    private Institute institute;


    public Subject(String name, String description,Institute institute) {
        this.name = name;
        this.description = description;
        this.institute = institute;
        this.createdAt = LocalDateTime.now();
        this.lastUpdate = null;
    }
}
