package elite.sas.core.repository;

import elite.sas.core.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByAdmissionNumber(UUID admissionNumber);
}
