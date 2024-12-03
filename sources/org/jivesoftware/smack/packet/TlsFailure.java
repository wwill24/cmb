package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

public final class TlsFailure implements Nonza {
    public static final String ELEMENT = "failure";
    public static final TlsFailure INSTANCE = new TlsFailure();
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", "failure");

    private TlsFailure() {
    }

    public String getElementName() {
        return "failure";
    }

    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<failure xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>";
    }
}
