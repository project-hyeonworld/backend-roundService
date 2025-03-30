package io.roundservice.common.event;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public interface EventPublisher<T> {
  void execute(T event);
}
