package com.instaclass.instituteservice.service.impl;
import com.instaclass.instituteservice.entity.Subject;
import com.instaclass.instituteservice.repository.InstituteRepository;
import com.instaclass.instituteservice.repository.SubjectRepository;
import com.instaclass.instituteservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;
    private InstituteRepository instituteRepository;

    @Override
    public Subject saveSubject(Subject subject) {

        return subjectRepository.save(Subject.builder()
                .name(subject.getName())
                .description(subject.getDescription())
                .createdAt(LocalDateTime.now())
                .institute(instituteRepository.getReferenceById(subject.getInstitute().getId()))
                .build());
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findSubjectById(id);
    }
}
