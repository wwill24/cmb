package org.jivesoftware.smackx.sid.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class StanzaIdElement extends StableAndUniqueIdElement {
    public static final String ATTR_BY = "by";
    public static final String ELEMENT = "stanza-id";
    public static final String NAMESPACE = "urn:xmpp:sid:0";
    public static final QName QNAME = new QName("urn:xmpp:sid:0", ELEMENT);
    private final String by;

    public StanzaIdElement(String str) {
        this.by = str;
    }

    public static StanzaIdElement getStanzaId(Message message) {
        return (StanzaIdElement) message.getExtension(StanzaIdElement.class);
    }

    public static boolean hasStanzaId(Message message) {
        return getStanzaId(message) != null;
    }

    public String getBy() {
        return this.by;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:sid:0";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).attribute("id", getId()).attribute(ATTR_BY, getBy()).closeEmptyElement();
    }

    public StanzaIdElement(String str, String str2) {
        super(str);
        this.by = str2;
    }
}
