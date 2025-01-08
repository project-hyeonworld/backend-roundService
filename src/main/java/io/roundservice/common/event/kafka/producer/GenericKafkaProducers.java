package io.roundservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 6.
 */
public abstract class GenericKafkaProducers<E extends CustomEvent> implements KafkaProducerStrategy {

    protected List<GenericKafkaProducer<? extends E, ?, ?>> producers;
    protected final Executor executor;

    protected GenericKafkaProducers(List<GenericKafkaProducer<? extends E, ?, ?>> kafkaProducerStrategies) {
        producers = kafkaProducerStrategies;
        executor = Executors.newFixedThreadPool(producers.size());
    }

    public int size() {
        return producers.size();
    }

    public abstract void send(E event);
}
