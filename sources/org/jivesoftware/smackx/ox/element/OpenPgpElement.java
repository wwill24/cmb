package org.jivesoftware.smackx.ox.element;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.ox.util.Util;

public class OpenPgpElement implements ExtensionElement {
    public static final String ELEMENT = "openpgp";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    public static final QName QNAME = new QName("urn:xmpp:openpgp:0", ELEMENT);
    private final String base64EncodedOpenPgpMessage;

    public OpenPgpElement(String str) {
        this.base64EncodedOpenPgpMessage = (String) StringUtils.requireNotNullNorEmpty(str, "base64 encoded message MUST NOT be null nor empty.");
    }

    public static OpenPgpElement fromStanza(Stanza stanza) {
        return (OpenPgpElement) stanza.getExtension(OpenPgpElement.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getEncryptedBase64MessageContent() {
        return this.base64EncodedOpenPgpMessage;
    }

    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    public QName getQName() {
        return QNAME;
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(this.base64EncodedOpenPgpMessage.getBytes(Util.UTF8));
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket().append((CharSequence) this.base64EncodedOpenPgpMessage).closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
