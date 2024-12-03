package org.jivesoftware.smackx.gcm.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.json.packet.AbstractJsonPacketExtension;

public class GcmPacketExtension extends AbstractJsonPacketExtension {
    public static final String ELEMENT = "gcm";
    public static final String NAMESPACE = "google:mobile:data";
    public static final QName QNAME = new QName(NAMESPACE, "gcm");

    public GcmPacketExtension(String str) {
        super(str);
    }

    public static GcmPacketExtension from(Stanza stanza) {
        return (GcmPacketExtension) stanza.getExtension(GcmPacketExtension.class);
    }

    public String getElementName() {
        return "gcm";
    }

    public String getNamespace() {
        return NAMESPACE;
    }
}
