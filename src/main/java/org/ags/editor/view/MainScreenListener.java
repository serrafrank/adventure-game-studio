package org.ags.editor.view;

import lombok.extern.slf4j.Slf4j;
import org.ags.editor.events.APIMessage;
import org.ags.editor.events.EventId;
import org.ags.editor.events.listener.AbstractEventListener;
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
