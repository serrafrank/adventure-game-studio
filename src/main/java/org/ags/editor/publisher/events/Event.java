package org.ags.editor.publisher.events;

public interface Event<D> {

    String getName();

    D getData();

    Class<?> getSource();

}
