package org.ags.editor.events;

public record Notification<D>(
        EventId id,
        D data,
        Class<?> source) implements Event<D> {


    public Notification(EventId id, D data) {
        this(id, data, null);
    }

    public Notification(EventId id) {
        this(id, null, null);
    }
}
