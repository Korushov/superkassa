package ru.korushov.superkassa.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ru.korushov.superkassa.model.Example;


/**
 * @author Vitaly Korushov
 */
@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="5000")})
    Example findById(int id);
}
