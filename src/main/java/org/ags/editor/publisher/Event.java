package org.ags.editor.publisher;


import lombok.Data;

@Data
public class Event {
    private Object message;
    private String type;
    private Object body;

    public Event(Object message, Object body, String type) {
        this.message = message;
        this.body = body;
        this.type = type;
    }

    public Event(Object message, Object body) {
        this(message, body, null);
    }

    public Event(Object message) {
        this(message, null, null);
    }
}
