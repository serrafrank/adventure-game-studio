package org.ags.editor.publisher.events;


import lombok.Value;

@Value
public class Notification<D> implements Event<D> {

    String name;
    D data;
    Class<?> source;


    public Notification(String name, D data, Class<?> source) {
        this.name = name;
        this.data = data;
        this.source = source;
    }

    public Notification(String name, D data) {
        this(name, data, null);
    }

    public Notification(String name) {
        this(name, null, null);
    }
}
