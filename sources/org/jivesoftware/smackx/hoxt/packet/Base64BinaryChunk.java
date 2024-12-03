package org.jivesoftware.smackx.hoxt.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Base64BinaryChunk implements ExtensionElement {
    public static final String ATTRIBUTE_LAST = "last";
    public static final String ATTRIBUTE_NR = "nr";
    public static final String ATTRIBUTE_STREAM_ID = "streamId";
    public static final String ELEMENT_CHUNK = "chunk";
    public static final QName QNAME = new QName("urn:xmpp:http", ELEMENT_CHUNK);
    private final boolean last;
    private final int nr;
    private final String streamId;
    private final String text;

    public Base64BinaryChunk(String str, String str2, int i10, boolean z10) {
        this.text = (String) Objects.requireNonNull(str, "text must not be null");
        this.streamId = (String) Objects.requireNonNull(str2, "streamId must not be null");
        if (i10 >= 0) {
            this.nr = i10;
            this.last = z10;
            return;
        }
        throw new IllegalArgumentException("nr must be a non negative integer");
    }

    public String getElementName() {
        return QNAME.getLocalPart();
    }

    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    public int getNr() {
        return this.nr;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public String getText() {
        return this.text;
    }

    public boolean isLast() {
        return this.last;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(ATTRIBUTE_STREAM_ID, this.streamId);
        xmlStringBuilder.attribute(ATTRIBUTE_NR, this.nr);
        xmlStringBuilder.optBooleanAttribute(ATTRIBUTE_LAST, this.last);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((CharSequence) this.text);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public Base64BinaryChunk(String str, String str2, int i10) {
        this(str, str2, i10, false);
    }
}
