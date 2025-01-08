package io.roundservice.common.event.kafka.producer;

import io.partydashboardservice.common.event.CustomEvent;
import io.partydashboardservice.common.event.EventPublisher;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaSender<E extends CustomEvent> extends EventPublisher<E> {
}
