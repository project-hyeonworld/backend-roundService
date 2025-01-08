package io.roundservice.api.round.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 9.
 */
@Component
@RequiredArgsConstructor
public class RoundEventPublisherImpl implements RoundEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void execute(RoundEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
