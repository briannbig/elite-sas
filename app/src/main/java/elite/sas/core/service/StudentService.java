package elite.sas.core.service;

import elite.sas.core.entities.Student;
import elite.sas.core.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(UUID.fromString(id));
    }

    public Optional<Student> getStudentByAdmissionNumber(String admNumber) {
        return studentRepository.findByAdmissionNumber(UUID.fromString(admNumber));
    }


}
