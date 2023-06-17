package org.ags.editor.events;


public record GenericEventId(String value) implements EventId {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericEventId that)) return false;

        return value().equals(that.value());
    }
}
