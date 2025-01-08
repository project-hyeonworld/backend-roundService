package io.roundservice.api.round.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(RoundId.class)
public class Round {

  @Id
  @Column(name = "party_id")
  private Long partyId;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "round_id_generator")
  @GenericGenerator(
          name = "round_id_generator",
          strategy = "io.roundservice.api.round.infrastructure.entity.RoundIdGenerator"
  )
  @Column(name = "round_count")
  private Long roundCount;

  @Column(name = "game_id")
  private Long gameId;

  @Column(name = "target_id")
  private Long targetId;

  @Column(name = "created_at")
  private LocalDateTime createdAt;


  @Column(name = "terminated_at")
  private LocalDateTime terminatedAt;

  @PrePersist
  public void onCreate() {
    this.createdAt = LocalDateTime.now();
  }
}
