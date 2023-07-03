package com.instaclass.accountservice.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
/*
@SqlResultSetMapping(
        name="account.getAccountRequests",
        classes={
                @ConstructorResult(
                        targetClass=Account.class,
                        columns={
                                @ColumnResult(name="account_id"),
                        }
                )
        }
)

@NamedNativeQuery(name="getAccountRequests", query="SELECT RJI.institute_id as instituteId, RJI.account_id as accountId, RJI.role, RJI.status, A.name, A.last_name as lastName, A.username, A.email FROM account AS A INNER JOIN request_join_institute AS RJI ON A.id = RJI.account_id WHERE RJI.institute_id =:institute_id ", resultSetMapping="account.getAccountRequests")
*/
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "last_update")
    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<AccountInstitute> accountInstitutes;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<RequestJoinInstitute> requestJoinInstitutes;

    public Account(String name, String lastName, String username, String password, Date dateOfBirth, String email) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;

    }
}
