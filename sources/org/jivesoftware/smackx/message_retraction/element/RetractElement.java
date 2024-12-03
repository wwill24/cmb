package org.jivesoftware.smackx.message_retraction.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class RetractElement implements ExtensionElement {
    public static final String ELEMENT = "retract";
    public static final String NAMESPACE = "urn:xmpp:message-retract:0";
    private static final String NAMESPACE_0 = "urn:xmpp:message-retract:0";
    private static final String NAMESPACE_WITHOUT_VERSION = "urn:xmpp:message-retract";

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:message-retract:0";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }
}
