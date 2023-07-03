package com.instaclass.accountservice.repository;

import com.instaclass.accountservice.Entity.RequestJoinInstitute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequestJoinInstituteRepository extends JpaRepository<RequestJoinInstitute,Long> {
    @Query(nativeQuery = true,
            value = "SELECT RJI.institute_id as instituteId, RJI.account_id as accountId, RJI.role, RJI.status, A.name, A.last_name as lastName, A.username, A.email "
                    + "FROM account AS A "
                    + "INNER JOIN request_join_institute AS RJI "
                    + "ON A.id = RJI.account_id "
                    + "WHERE RJI.institute_id =:institute_id ")
    String[][] getAllAccountRequestsToJoinInstitute(@Param("institute_id") Long id);
}
