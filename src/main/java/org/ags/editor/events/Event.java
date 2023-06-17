package org.ags.editor.events;


public interface Event<D> {

    EventId id();

    D data();

    Class<?> source();

}
