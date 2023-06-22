package org.ags.editor.view;

import lombok.extern.slf4j.Slf4j;
import org.ags.editor.events.EventId;
import org.ags.editor.events.Notification;
import org.ags.editor.events.listener.AbstractEventListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

import static org.ags.editor.events.APIMessage.CREATE;

@Slf4j
@Component
public class MainScreenListener extends AbstractEventListener {

    private final MainScreen mainScreen;

    @Override
    protected Map<EventId, Consumer<Notification<?>>> getAcceptedNotifications() {
        return Map.of(
                CREATE, this::onCreate
        );
    }

    public MainScreenListener(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    protected void onNotification(Notification<?> notification) {
        this.consume(notification);
    }

    private void onCreate(Notification<?> notification) {
        log.info("MainScreenListener onCreate");
    }
}
