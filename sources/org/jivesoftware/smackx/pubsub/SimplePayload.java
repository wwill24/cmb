package org.jivesoftware.smackx.pubsub;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class SimplePayload implements ExtensionElement {
    private final String elemName;
    private final String ns;
    private final String payload;

    public SimplePayload(String str) {
        try {
            QName qName = PacketParserUtils.getParserFor(str).getQName();
            this.payload = str;
            this.elemName = (String) StringUtils.requireNotNullNorEmpty(qName.getLocalPart(), "Could not determine element name from XML payload");
            this.ns = (String) StringUtils.requireNotNullNorEmpty(qName.getNamespaceURI(), "Could not determine namespace from XML payload");
        } catch (IOException | XmlPullParserException e10) {
            throw new AssertionError(e10);
        }
    }

    public String getElementName() {
        return this.elemName;
    }

    public String getNamespace() {
        return this.ns;
    }

    public String toString() {
        return getClass().getName() + "payload [" + toXML() + "]";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return this.payload;
    }

    @Deprecated
    public SimplePayload(String str, String str2, CharSequence charSequence) {
        this(charSequence.toString());
        if (!str.equals(this.elemName)) {
            throw new IllegalArgumentException();
        } else if (!str2.equals(this.ns)) {
            throw new IllegalArgumentException();
        }
    }
}
