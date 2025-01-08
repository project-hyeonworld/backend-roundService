package io.roundservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaProducerManager<E extends CustomEvent> implements KafkaProducerManager<E> {

    public abstract void send(E event);
}