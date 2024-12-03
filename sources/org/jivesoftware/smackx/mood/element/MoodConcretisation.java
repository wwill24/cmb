package org.jivesoftware.smackx.mood.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class MoodConcretisation implements ExtensionElement {
    public String getMood() {
        return getElementName();
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }
}
