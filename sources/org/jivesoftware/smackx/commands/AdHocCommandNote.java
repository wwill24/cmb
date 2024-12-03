package org.jivesoftware.smackx.commands;

public class AdHocCommandNote {
    private final Type type;
    private final String value;

    public enum Type {
        info,
        warn,
        error
    }

    public AdHocCommandNote(Type type2, String str) {
        this.type = type2;
        this.value = str;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}
