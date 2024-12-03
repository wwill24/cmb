package org.jivesoftware.smackx.httpfileupload.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class FileTooLargeError implements ExtensionElement {
    public static final String ELEMENT = "file-too-large";
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    private final long maxFileSize;
    private final String namespace;

    public FileTooLargeError(long j10) {
        this(j10, "urn:xmpp:http:upload:0");
    }

    public static FileTooLargeError from(IQ iq) {
        StanzaError error = iq.getError();
        if (error == null) {
            return null;
        }
        return (FileTooLargeError) error.getExtension(ELEMENT, "urn:xmpp:http:upload:0");
    }

    public String getElementName() {
        return ELEMENT;
    }

    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    public String getNamespace() {
        return this.namespace;
    }

    protected FileTooLargeError(long j10, String str) {
        this.maxFileSize = j10;
        this.namespace = str;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.element("max-file-size", String.valueOf(this.maxFileSize));
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
