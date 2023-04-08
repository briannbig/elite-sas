package elite.sas.core.repository;


import elite.sas.core.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Brian Barasa
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {


    Optional<Account> findByAppUserUserName(String username) ;

    Optional<Account> findByAppUserEmail(String email);
}
