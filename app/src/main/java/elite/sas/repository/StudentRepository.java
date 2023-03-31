package elite.sas.repository;

import elite.sas.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByAdmissionNumber(UUID admissionNumber);
}
