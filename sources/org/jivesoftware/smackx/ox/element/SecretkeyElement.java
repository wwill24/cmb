package org.jivesoftware.smackx.ox.element;

import java.nio.charset.Charset;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class SecretkeyElement implements ExtensionElement {
    public static final String ELEMENT = "secretkey";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final byte[] b64Data;

    public SecretkeyElement(byte[] bArr) {
        this.b64Data = (byte[]) Objects.requireNonNull(bArr);
    }

    public byte[] getB64Data() {
        return this.b64Data;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).rightAngleBracket().append((CharSequence) new String(this.b64Data, Charset.forName("UTF-8"))).closeElement((NamedElement) this);
    }
}
