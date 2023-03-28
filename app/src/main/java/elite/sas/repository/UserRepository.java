package elite.sas.repository;

import elite.sas.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {

}
