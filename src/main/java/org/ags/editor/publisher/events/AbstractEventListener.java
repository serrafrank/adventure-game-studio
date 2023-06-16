package org.ags.editor.publisher.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

import java.util.Set;

@Slf4j
public abstract class AbstractEventListener {
    protected final Set<EventId> acceptedNotifications;

    protected abstract void onNotification(EventId id, Object data);


    protected AbstractEventListener(Set<EventId> acceptedNotifications) {
        this.acceptedNotifications = acceptedNotifications;
        log.trace("Created {} with accepted notifications: {}", this, acceptedNotifications);
    }

    protected AbstractEventListener(EventId... acceptedNotifications) {
        this(Set.of(acceptedNotifications));
    }

    protected AbstractEventListener() {
        this(Set.of());
    }


    protected boolean accepts(Notification<?> notification) {
        log.info("Checking if {} accepts {}", this, notification);
        return acceptedNotifications
                .stream()
                .anyMatch(s -> s.equals(notification.id()));
    }

    @EventListener
    public void onNotification(Notification<?> notification) {
        if (accepts(notification)) {
            log.info("{} accepts {}", this, notification);
            onNotification(notification.id(), notification.data());
        } else {
            log.trace("{} does not accept {}", this, notification);
        }
    }
}
