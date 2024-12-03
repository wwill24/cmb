package org.jivesoftware.smackx.jingle.element;

import java.util.List;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class UnknownJingleContentTransport extends JingleContentTransport {
    private final StandardExtensionElement standardExtensionElement;

    public UnknownJingleContentTransport(StandardExtensionElement standardExtensionElement2) {
        super((List<JingleContentTransportCandidate>) null, (JingleContentTransportInfo) null);
        this.standardExtensionElement = standardExtensionElement2;
    }

    public List<JingleContentTransportCandidate> getCandidates() {
        throw new UnsupportedOperationException();
    }

    public String getElementName() {
        return this.standardExtensionElement.getElementName();
    }

    public JingleContentTransportInfo getInfo() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        return this.standardExtensionElement.getNamespace();
    }

    public StandardExtensionElement getStandardExtensionElement() {
        return this.standardExtensionElement;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return this.standardExtensionElement.toXML(xmlEnvironment);
    }
}
