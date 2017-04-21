package eu.nyerel.searchtable.example.core.repository;

import eu.nyerel.searchtable.example.core.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
