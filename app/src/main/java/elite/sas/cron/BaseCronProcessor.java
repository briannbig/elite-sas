package elite.sas.cron;

import elite.sas.entities.BaseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * @author Brian Barasa
 * @param <T>
 */
@Service
@RequiredArgsConstructor
public abstract class BaseCronProcessor<T extends BaseModel> {
   protected abstract JpaRepository<T, UUID> repository();

   public abstract T process(T model);

}
