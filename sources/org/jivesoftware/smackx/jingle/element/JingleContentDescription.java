package org.jivesoftware.smackx.jingle.element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class JingleContentDescription implements ExtensionElement {
    public static final String ELEMENT = "description";
    private final List<NamedElement> payloads;

    protected JingleContentDescription(List<? extends NamedElement> list) {
        if (list != null) {
            this.payloads = Collections.unmodifiableList(list);
        } else {
            this.payloads = Collections.emptyList();
        }
    }

    /* access modifiers changed from: protected */
    public void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
    }

    public String getElementName() {
        return "description";
    }

    public List<NamedElement> getJingleContentDescriptionChildren() {
        return this.payloads;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        addExtraAttributes(xmlStringBuilder);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.payloads);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
