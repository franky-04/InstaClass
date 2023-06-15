package com.instaclass.instituteservice.service;

import com.instaclass.instituteservice.entity.Subject;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    Subject getSubjectById(Long id);
}
