package io.roundservice.api.round.infrastructure.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 28.
 */
@Getter
public class RoundId implements Serializable {
    private Long partyId;
    private Long roundCount;

    protected RoundId() {}

    private RoundId(long partyId, long roundCount) {
        this.partyId = partyId;
        this.roundCount = roundCount;
    }

    public static RoundId from (byte[] roundIdBytes) {
        if (roundIdBytes != null) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(roundIdBytes);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Object obj = ois.readObject();
                if (obj instanceof RoundId) {
                    return (RoundId) obj;
                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (IOException | ClassNotFoundException e) {
                // Handle the exception appropriately
                e.printStackTrace();
            }
        }
        return null;
    }

    public static RoundId from(long partyId, long partyRoundId) {
        return new RoundId(partyId, partyRoundId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundId roundId = (RoundId) o;
        return Objects.equals(partyId, roundId.partyId) &&
                Objects.equals(roundCount, roundId.roundCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyId, roundCount);
    }
}