package io.roundservice.common.event.kafka.producer;

import io.sessionservice.common.event.CustomEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 5.
 */
public abstract class GenericKafkaProducer<E extends CustomEvent, K, V> implements KafkaProducerStrategy {

    protected final String TOPIC;
    protected KafkaProducer<K, V> kafkaProducer;

    protected GenericKafkaProducer(String topic) {
        TOPIC = topic;
    }

    public abstract Class<E> getEventClass();

    public abstract void send(E event);

    protected abstract ProducerRecord<K, V> produce(E event);

    protected abstract ProducerRecord<K,V> convertToRecord(E event);
}
