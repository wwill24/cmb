package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

public final class TlsProceed implements Nonza {
    public static final String ELEMENT = "proceed";
    public static final TlsProceed INSTANCE = new TlsProceed();
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", ELEMENT);

    private TlsProceed() {
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<proceed xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>";
    }
}
