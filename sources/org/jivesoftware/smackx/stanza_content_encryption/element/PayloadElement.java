package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class PayloadElement implements NamedElement {
    public static final String ELEMENT = "payload";
    private final List<ExtensionElement> payloadElements;

    public PayloadElement(List<ExtensionElement> list) {
        this.payloadElements = Collections.unmodifiableList(list);
    }

    public String getElementName() {
        return "payload";
    }

    public List<ExtensionElement> getItems() {
        return this.payloadElements;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((NamedElement) this).rightAngleBracket();
        rightAngleBracket.append((Collection<? extends Element>) this.payloadElements);
        return rightAngleBracket.closeElement((NamedElement) this);
    }
}
