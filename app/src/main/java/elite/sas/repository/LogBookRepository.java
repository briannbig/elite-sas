package elite.sas.repository;

import elite.sas.entities.LogBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogBookRepository extends JpaRepository<LogBook, UUID> {
}
