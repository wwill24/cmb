package org.jivesoftware.smackx.jingle_filetransfer.element;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hashes.element.HashElement;

public class Range implements FullyQualifiedElement {
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_OFFSET = "offset";
    public static final String ELEMENT = "range";
    public static final String NAMESPACE = "urn:xmpp:jingle:apps:file-transfer:5";
    private final HashElement hash;
    private final Integer length;
    private final Integer offset;

    public Range() {
        this((Integer) null, (Integer) null, (HashElement) null);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (getOffset() == range.getOffset() && getLength() == range.getLength() && getHash().equals(range.getHash())) {
            return true;
        }
        return false;
    }

    public String getElementName() {
        return "range";
    }

    public HashElement getHash() {
        return this.hash;
    }

    public int getLength() {
        return this.length.intValue();
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }

    public int getOffset() {
        return this.offset.intValue();
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.optAttribute(ATTR_OFFSET, (Number) this.offset);
        xmlStringBuilder.optAttribute(ATTR_LENGTH, (Number) this.length);
        if (this.hash != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Element) this.hash);
            xmlStringBuilder.closeElement((NamedElement) this);
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        return xmlStringBuilder;
    }

    public Range(int i10) {
        this((Integer) null, Integer.valueOf(i10), (HashElement) null);
    }

    public Range(int i10, int i11) {
        this(Integer.valueOf(i10), Integer.valueOf(i11), (HashElement) null);
    }

    public Range(Integer num, Integer num2, HashElement hashElement) {
        this.offset = num;
        this.length = num2;
        this.hash = hashElement;
    }
}
