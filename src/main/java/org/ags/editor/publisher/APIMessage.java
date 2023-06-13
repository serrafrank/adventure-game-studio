package org.ags.editor.publisher;

public enum APIMessage {
    START_APP, CREATE, RESIZE, PAUSE, RESUME;

    @Override
    public String toString() {
        return getClass() + "." + name();
    }
}
