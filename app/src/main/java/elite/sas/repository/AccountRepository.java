package elite.sas.repository;


import elite.sas.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Brian Barasa
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {


    Optional<Account> findByUserUserName(String username) ;
}
