package org.ags.editor.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ags.editor.publisher.events.Event;
import org.ags.editor.publisher.events.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;


    private final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);


    //    Notification
    public <T> void publish(EventId id, T data) {
        publish(new Notification<>(id, data, getSource()));
    }

    public void publish(EventId id) {
        publish(new Notification<>(id, EventData.EMPTY, getSource()));
    }

    public void publish(String id) {
        publish(new Notification<>(new GenericEventId(id), EventData.EMPTY, getSource()));
    }

    public void publish(Event<?> event) {
        log.debug("Publishing event: {}", event);
        applicationEventPublisher.publishEvent(event);
    }

    private Class<?> getSource() {
        return walker.walk(frames -> frames
                        .map(StackWalker.StackFrame::getDeclaringClass)
                        .filter(c -> !c.equals(this.getClass()))
                        .findFirst())
                .orElse(null);
    }

}
