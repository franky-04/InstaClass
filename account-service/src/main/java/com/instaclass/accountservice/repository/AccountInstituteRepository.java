package com.instaclass.accountservice.repository;

import com.instaclass.accountservice.Entity.AccountInstitute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AccountInstituteRepository extends JpaRepository<AccountInstitute,Long> {
    AccountInstitute findAccountInstituteById(Long id);
    @Query(nativeQuery = true,
            value = "SELECT AI.institute_id as instituteId, AI.account_id as accountId, AI.role, A.name, A.last_name as lastName, A.username, A.email "
                    + "FROM account AS A "
                    + "INNER JOIN account_institute AS AI "
                    + "ON A.id = AI.account_id "
                    + "WHERE AI.institute_id =:institute_id ")
    String[][] getAllInstituteAccounts(@Param("institute_id") Long id);
}

