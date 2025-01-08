package io.roundservice.api.round.infrastructure.jpa;

import io.roundservice.api.round.infrastructure.entity.Round;
import io.roundservice.api.round.infrastructure.entity.RoundId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
public interface RoundJpaRepository extends JpaRepository<Round, RoundId> {

}
