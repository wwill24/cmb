package org.jivesoftware.smack.packet;

public final class StreamClose implements Nonza {
    public static final StreamClose INSTANCE = new StreamClose();

    private StreamClose() {
    }

    public String getElementName() {
        return StreamOpen.ELEMENT;
    }

    public String getNamespace() {
        return "(none)";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "</" + getElementName() + '>';
    }
}
