package org.ags.editor.publisher.events;

public interface Event<D> {

    EventId id();

    D data();

    Class<?> source();

}
