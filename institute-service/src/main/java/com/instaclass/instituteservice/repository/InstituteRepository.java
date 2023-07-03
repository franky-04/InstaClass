package com.instaclass.instituteservice.repository;

import com.instaclass.instituteservice.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute,Long> {

    Institute findInstituteById(Long id);


}
