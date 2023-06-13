package org.ags.editor.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ags.editor.publisher.events.Event;
import org.ags.editor.publisher.events.Notification;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;


    private final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);


    //    Notification
    public <T> void publish(Enum<?> name, T data) {
        publish(new Notification<>(name.toString(), data, getSource()));
    }

    public void publish(Enum<?> name) {
        publish(new Notification<>(name.toString(), null, getSource()));
    }

    public <T> void publish(String name, T data) {
        publish(new Notification<>(name, data, getSource()));
    }

    public void publish(String name) {
        publish(new Notification<>(name, null, getSource()));
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
