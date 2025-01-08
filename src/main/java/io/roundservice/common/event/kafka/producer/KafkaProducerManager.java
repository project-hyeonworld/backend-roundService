package io.roundservice.common.event.kafka.producer;

import io.partydashboardservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaProducerManager<E extends CustomEvent, KPS extends KafkaProducerStrategy> {
    KPS getProducer(E event);
}
