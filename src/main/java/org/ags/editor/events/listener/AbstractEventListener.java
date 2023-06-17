package org.ags.editor.events.listener;

import lombok.extern.slf4j.Slf4j;
import org.ags.editor.events.EventId;
import org.ags.editor.events.Notification;
import org.springframework.context.event.EventListener;

import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public abstract class AbstractEventListener {

    protected abstract Map<EventId, Consumer<Notification<?>>> getAcceptedNotifications();

    protected abstract void onNotification(Notification<?> notification);

    protected boolean accepts(Notification<?> notification) {
        log.info("Checking if {} accepts {}", this, notification);
        return getAcceptedNotifications()
                .keySet()
                .stream()
                .anyMatch(s -> s.equals(notification.id()));
    }

    protected void consume(Notification<?> notification) {
        getAcceptedNotifications()
                .getOrDefault(notification.id(), n -> log.warn("No consumer for {}", n))
                .accept(notification);
    }

    @EventListener
    public void handleNotification(Notification<?> notification) {
        if (accepts(notification)) {
            log.info("{} accepts {}", this, notification);
            onNotification(notification);
        } else {
            log.trace("{} does not accept {}", this, notification);
        }
    }
}
