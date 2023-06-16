package org.ags.editor.publisher.events;


public record GenericEventId(String value) implements EventId {

    @Override
    public String value() {
        return getClass() + "." + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericEventId that)) return false;

        return value().equals(that.value());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
