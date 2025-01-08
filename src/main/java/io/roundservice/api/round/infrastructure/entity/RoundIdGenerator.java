package io.roundservice.api.round.infrastructure.entity;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 28.
 */
public class RoundIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Round round = (Round) object;
        String query = "SELECT COALESCE(MAX(r.roundCount), 0) + 1 FROM Round r WHERE r.partyId = :partyId";
        Long nextId = (Long) session.createQuery(query)
                .setParameter("partyId", round.getPartyId())
                .uniqueResult();
        return nextId;
    }
}
