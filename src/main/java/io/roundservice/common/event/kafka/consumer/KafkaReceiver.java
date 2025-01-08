package io.roundservice.common.event.kafka.consumer;

import io.partydashboardservice.common.event.CustomEvent;
import io.partydashboardservice.common.event.EventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaReceiver<E extends CustomEvent> extends EventListener<E> {
}
