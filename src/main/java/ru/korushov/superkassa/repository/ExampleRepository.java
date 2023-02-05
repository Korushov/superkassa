package ru.korushov.superkassa.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ru.korushov.superkassa.model.Example;
import ru.korushov.superkassa.util.MyJson;

import java.util.Optional;

/**
 * @author Vitaly Korushov
 */
@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="5000")})
    Example findById(int id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Example e SET e.obj=?1 WHERE e.id=?2")
    void update(MyJson myJson, int id);
}
