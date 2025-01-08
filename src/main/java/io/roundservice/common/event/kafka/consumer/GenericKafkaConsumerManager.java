package io.roundservice.common.event.kafka.consumer;

import io.partydashboardservice.common.event.CustomEvent;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 7.
 */
public abstract class GenericKafkaConsumerManager<E extends CustomEvent> implements
        KafkaConsumerManager<E> {

    protected GenericKafkaConsumers<E> consumers;

    protected GenericKafkaConsumerManager(GenericKafkaConsumers<E> genericKafkaConsumers) {
        consumers = genericKafkaConsumers;
    }

    public abstract List<E> receive();
}
