package com.instaclass.instituteservice.repository;

import com.instaclass.instituteservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findSubjectById(Long id);
}
