package org.jivesoftware.smackx.json.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Stanza;

public class JsonPacketExtension extends AbstractJsonPacketExtension {
    public static final String ELEMENT = "json";
    public static final String NAMESPACE = "urn:xmpp:json:0";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    public JsonPacketExtension(String str) {
        super(str);
    }

    public static JsonPacketExtension from(Stanza stanza) {
        return (JsonPacketExtension) stanza.getExtension(JsonPacketExtension.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
