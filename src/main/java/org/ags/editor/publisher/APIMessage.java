package org.ags.editor.publisher;

import org.ags.editor.publisher.events.EventId;
import org.ags.editor.publisher.events.GenericEventId;

public class APIMessage {
    public static final EventId START_APP = new GenericEventId("START_APP");
    public static final EventId CREATE = new GenericEventId("CREATE");
    public static final EventId RESIZE = new GenericEventId("RESIZE");
    public static final EventId PAUSE = new GenericEventId("PAUSE");
    public static final EventId RESUME = new GenericEventId("RESUME");

}
