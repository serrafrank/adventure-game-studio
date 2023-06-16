package org.ags.editor.view;

import lombok.extern.slf4j.Slf4j;
import org.ags.editor.publisher.APIMessage;
import org.ags.editor.publisher.events.AbstractEventListener;
import org.ags.editor.publisher.events.EventId;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainScreenListener extends AbstractEventListener {

    private final MainScreen mainScreen;

    public MainScreenListener(MainScreen mainScreen) {
        super(APIMessage.CREATE);
        this.mainScreen = mainScreen;
    }

    @Override
    protected void onNotification(EventId id, Object data) {

    }
}
