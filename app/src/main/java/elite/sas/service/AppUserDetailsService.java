package elite.sas.service;

import elite.sas.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Brian Barasa
 */

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return accountRepository.findByAppUserUserName(userName)
                .orElseThrow(() -> new RuntimeException("Username not found!"));
    }
}
