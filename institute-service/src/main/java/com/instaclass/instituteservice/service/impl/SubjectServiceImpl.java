package com.instaclass.instituteservice.service.impl;
import com.instaclass.instituteservice.DTO.subjectDTO.GetSubjectDTO;
import com.instaclass.instituteservice.DTO.subjectDTO.PostSubjectDTO;
import com.instaclass.instituteservice.entity.Institute;
import com.instaclass.instituteservice.entity.Subject;
import com.instaclass.instituteservice.mappers.SubjectMapper;
import com.instaclass.instituteservice.repository.InstituteRepository;
import com.instaclass.instituteservice.repository.SubjectRepository;
import com.instaclass.instituteservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;
    private InstituteRepository instituteRepository;
    @Override
    public GetSubjectDTO saveSubject(PostSubjectDTO postSubjectDTO) {
        //recupera institute dall'id nell'oggetto subject

        Institute institute = instituteRepository.findInstituteById(postSubjectDTO.getInstitute_id());
        Subject subject = new Subject(
                postSubjectDTO.getName(),
                postSubjectDTO.getDescription(),
                institute
        );
        return SubjectMapper.mapSubjectToSubjectDTO(subjectRepository.save(subject));
    }

    @Override
    public GetSubjectDTO getSubjectById(Long id) {
        return SubjectMapper.mapSubjectToSubjectDTO(subjectRepository.findSubjectById(id));
    }



    //ELIMINARE
   /* @Override
    public GetSubjectAndInstituteDTO getSubjectAndInstituteById(Long id) {
        Subject subject = subjectRepository.findSubjectById(id);
        //una volta recuperati subject ed institute corrispondente crea DTO di risposta
        //GetSubjectAndInstituteDTO getSubjectAndInstituteDTO = SubjectMapper.mapSubjectAndInstituteToSubjectAndInstituteDTO(subjectRepository.findSubjectById(id));
        //getSubjectAndInstituteDTO.setInstitute(institute);
        return new GetSubjectAndInstituteDTO(
          subject.getId(),
          subject.getName(),
          subject.getDescription(),
                subject.getInstitute()
        );
    }*/
}
