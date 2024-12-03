package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;

public class StartTls implements Nonza {
    public static final String ELEMENT = "starttls";
    public static final StartTls INSTANCE = new StartTls();
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", ELEMENT);
    private final boolean required;

    public StartTls() {
        this(false);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    public boolean required() {
        return this.required;
    }

    public StartTls(boolean z10) {
        this.required = z10;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.required) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.emptyElement(FormField.Required.ELEMENT);
            xmlStringBuilder.closeElement((NamedElement) this);
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        return xmlStringBuilder;
    }
}
