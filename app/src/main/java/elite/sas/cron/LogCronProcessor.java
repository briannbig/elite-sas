package elite.sas.cron;

import elite.sas.entities.Log;
import elite.sas.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * Checks if student submitted work done for that day and sets it as no record if no work was submitted.
 *
 */
@Component
@RequiredArgsConstructor
public class LogCronProcessor extends BaseCronProcessor<Log> {

    private final LogRepository logRepository;
    @Override
    protected JpaRepository<Log, UUID> repository() {
        return logRepository;
    }

    @Override
    public Log process(Log log) {
        if (Objects.isNull(log.getWorkDone())) {
            log.setWorkDone("No record");
            log = repository().save(log);
        }
        return logRepository.save(log);

    }
}
