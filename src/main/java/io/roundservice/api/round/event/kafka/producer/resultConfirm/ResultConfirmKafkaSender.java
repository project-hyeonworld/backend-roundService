package io.roundservice.api.round.event.kafka.producer.resultConfirm;

import io.roundservice.api.round.event.kafka.producer.resultConfirm.event.ResultConfirmEvent;
import io.roundservice.common.event.kafka.producer.GenericKafkaProducerManager;
import io.roundservice.common.event.kafka.producer.GenericKafkaSender;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
@Component
public class ResultConfirmKafkaSender extends GenericKafkaSender <ResultConfirmEvent> {

    protected ResultConfirmKafkaSender(
            GenericKafkaProducerManager<ResultConfirmEvent> kafkaProducerManager) {
        super(kafkaProducerManager);
    }
}
