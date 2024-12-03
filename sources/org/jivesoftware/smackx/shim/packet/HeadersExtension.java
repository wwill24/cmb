package org.jivesoftware.smackx.shim.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class HeadersExtension implements ExtensionElement {
    public static final String ELEMENT = "headers";
    public static final String NAMESPACE = "http://jabber.org/protocol/shim";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final List<Header> headers;

    public HeadersExtension(List<Header> list) {
        if (list != null) {
            this.headers = Collections.unmodifiableList(list);
        } else {
            this.headers = Collections.emptyList();
        }
    }

    public static HeadersExtension from(Stanza stanza) {
        return (HeadersExtension) stanza.getExtension(HeadersExtension.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.headers);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
