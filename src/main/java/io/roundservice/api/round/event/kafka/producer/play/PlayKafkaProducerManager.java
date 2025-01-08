package io.roundservice.api.round.event.kafka.producer.play;

import io.roundservice.api.round.event.kafka.producer.play.event.PlayEvent;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducer;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 12.
 */
@Component
public class PlayKafkaProducerManager extends GenericKafkaProducerManager<PlayEvent> {
    private final GenericKafkaProducer<PlayEvent, ?, ?> producer;

    public PlayKafkaProducerManager(GenericKafkaProducer<PlayEvent, ?, ?> producer) {
        this.producer = producer;
    }

    @Override
    public void send(PlayEvent event) {
        producer.send(event);
    }
}
