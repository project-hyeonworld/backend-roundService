package io.roundservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaSender<E extends CustomEvent> implements KafkaSender<E> {

    protected GenericKafkaProducerManager<E> manager;

    protected GenericKafkaSender(GenericKafkaProducerManager<E> kafkaProducerManager) {
        manager = kafkaProducerManager;
    }

    public void execute(E event) {
        manager.send(event);
    }
}
