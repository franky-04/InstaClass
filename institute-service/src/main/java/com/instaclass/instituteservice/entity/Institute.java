package com.instaclass.instituteservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "last_update")
    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @OneToMany(mappedBy = "institute", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    public Institute(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.lastUpdate = null;
    }
}
