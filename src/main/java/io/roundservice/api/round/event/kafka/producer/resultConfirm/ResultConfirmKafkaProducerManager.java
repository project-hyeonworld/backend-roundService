package io.roundservice.api.round.event.kafka.producer.resultConfirm;


import io.roundservice.api.round.event.kafka.producer.resultConfirm.event.ResultConfirmEvent;
import io.roundservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.roundservice.common.event.CustomEvent;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducer;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.roundservice.common.event.kafka.producer.KafkaProducerStrategy;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ResultConfirmKafkaProducerManager extends GenericKafkaProducerManager<ResultConfirmEvent> {

    private final GenericKafkaProducer<ResultConfirmEvent, ?, ?> producer;

    public ResultConfirmKafkaProducerManager(GenericKafkaProducer<ResultConfirmEvent, ?, ?> producer) {
        this.producer = producer;
    }

    @Override
    public void send(ResultConfirmEvent event) {
        producer.send(event);
    }
}
