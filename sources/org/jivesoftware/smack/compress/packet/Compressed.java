package org.jivesoftware.smack.compress.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;

public final class Compressed implements Nonza {
    public static final String ELEMENT = "compressed";
    public static final Compressed INSTANCE = new Compressed();
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public static final QName QNAME = new QName("http://jabber.org/protocol/compress", ELEMENT);

    private Compressed() {
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<compressed xmlns='http://jabber.org/protocol/compress'/>";
    }
}
