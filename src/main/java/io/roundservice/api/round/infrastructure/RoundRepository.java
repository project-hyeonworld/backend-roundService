package io.roundservice.api.round.infrastructure;

import io.roundservice.api.round.infrastructure.entity.Round;
import java.util.Optional;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
public interface RoundRepository {

    Round insert(Round round);

    Optional<Round> findById(long partyId, long roundCount);

    Round update(Round round);

    Optional<Round> findByPartyId(long partyId);

    void terminateAll();

    void terminate(long partyId, long roundCount);
}
