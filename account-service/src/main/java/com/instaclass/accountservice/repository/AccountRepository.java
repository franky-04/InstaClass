package com.instaclass.accountservice.repository;

import com.instaclass.accountservice.DTO.JoinDTO.AccountJoinRequestsDTO;
import com.instaclass.accountservice.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);

    //recupera tutte le richieste ricevuto da un account di unirsi ad un istituto dato l'account id
    @Query(nativeQuery = true,
            value = "SELECT RJI.institute_id as instituteId, RJI.account_id as accountId, RJI.role, RJI.status, A.name, A.last_name as lastName, A.username, A.email "
                    + "FROM account AS A "
                    + "INNER JOIN request_join_institute AS RJI "
                    + "ON A.id = RJI.account_id "
                    + "WHERE RJI.institute_id =:institute_id ")
    String[][] getAllAccountRequestsToJoinInstitute(@Param("institute_id") Long id);

    //recupera tutti i collegamenti di un account verso gli istituti dato account id


}
