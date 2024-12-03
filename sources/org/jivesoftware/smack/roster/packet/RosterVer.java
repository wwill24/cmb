package org.jivesoftware.smack.roster.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class RosterVer implements ExtensionElement {
    public static final String ELEMENT = "ver";
    public static final RosterVer INSTANCE = new RosterVer();
    public static final String NAMESPACE = "urn:xmpp:features:rosterver";

    private RosterVer() {
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
