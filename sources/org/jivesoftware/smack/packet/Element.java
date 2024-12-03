package org.jivesoftware.smack.packet;

public interface Element {
    CharSequence toXML(String str) {
        return toXML(new XmlEnvironment(str));
    }

    CharSequence toXML(XmlEnvironment xmlEnvironment);

    CharSequence toXML() {
        return toXML(XmlEnvironment.EMPTY);
    }
}
