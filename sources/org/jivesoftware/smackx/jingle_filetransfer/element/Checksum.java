package org.jivesoftware.smackx.jingle_filetransfer.element;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleContent;

public class Checksum implements ExtensionElement {
    public static final String ATTR_CREATOR = "creator";
    public static final String ATTR_NAME = "name";
    public static final String ELEMENT = "checksum";
    private final JingleContent.Creator creator;
    private final JingleFileTransferChild file;
    private final String name;

    public Checksum(JingleContent.Creator creator2, String str, JingleFileTransferChild jingleFileTransferChild) {
        this.creator = creator2;
        this.name = str;
        this.file = (JingleFileTransferChild) Objects.requireNonNull(jingleFileTransferChild, "file MUST NOT be null.");
        Objects.requireNonNull(jingleFileTransferChild.getHash(), "file MUST contain at least one hash element.");
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute("creator", (Enum<?>) this.creator);
        xmlStringBuilder.optAttribute("name", this.name);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Element) this.file);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
