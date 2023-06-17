package org.ags.editor.events;

public enum APIMessage implements EventId {
    START_APP,
    CREATE,
    RESIZE,
    PAUSE,
    RESUME,
    CHECK_EDITS_ACTION, DISPOSE;

    @Override
    public String value() {
        return getClass() + "." + name();
    }
}
