package com.instaclass.accountservice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="account_institute")
public class AccountInstitute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "last_update")
    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @Column(name = "role")
    private String role;

    //Foreign key logica
    @Column(name = "institute_id")
    private Long instituteId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;


    public AccountInstitute(Long instituteId, Account account, String role) {
        this.instituteId = instituteId;
        this.account = account;
        this.role = role;
    }

}
