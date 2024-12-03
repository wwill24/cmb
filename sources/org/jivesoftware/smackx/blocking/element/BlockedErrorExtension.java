package org.jivesoftware.smackx.blocking.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class BlockedErrorExtension implements ExtensionElement {
    public static final String ELEMENT = "blocked";
    public static final String NAMESPACE = "urn:xmpp:blocking:errors";

    public static BlockedErrorExtension from(Message message) {
        StanzaError error = message.getError();
        if (error == null) {
            return null;
        }
        return (BlockedErrorExtension) error.getExtension(ELEMENT, NAMESPACE);
    }

    public static boolean isInside(Message message) {
        return from(message) != null;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
