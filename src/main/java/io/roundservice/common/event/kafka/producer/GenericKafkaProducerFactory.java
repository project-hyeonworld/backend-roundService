package io.roundservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public class GenericKafkaProducerFactory<E extends CustomEvent> implements KafkaProducerFactory {

    protected final Map<Class<? extends E>, GenericKafkaProducer<? extends E, ?, ?>> strategies;

    protected GenericKafkaProducerFactory(List<GenericKafkaProducer<? extends E, ?, ?>> kafkaProducerStrategies) {
        strategies = kafkaProducerStrategies.stream()
                .collect(Collectors.toMap(GenericKafkaProducer::getEventClass, strategy -> strategy));
    }

    public GenericKafkaProducer<? extends E, ?, ?> getProducer(Class<? extends CustomEvent> eventClass) {
        return strategies.get(eventClass);
    }

}