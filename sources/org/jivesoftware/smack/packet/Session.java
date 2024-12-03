package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Session extends SimpleIQ {
    public static final String ELEMENT = "session";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-session";

    public static class Feature implements ExtensionElement {
        public static final String OPTIONAL_ELEMENT = "optional";
        public static final QName QNAME = new QName(Session.NAMESPACE, Session.ELEMENT);
        private final boolean optional;

        public Feature(boolean z10) {
            this.optional = z10;
        }

        public String getElementName() {
            return Session.ELEMENT;
        }

        public String getNamespace() {
            return Session.NAMESPACE;
        }

        public boolean isOptional() {
            return this.optional;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            if (this.optional) {
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.emptyElement(OPTIONAL_ELEMENT);
                xmlStringBuilder.closeElement((NamedElement) this);
            } else {
                xmlStringBuilder.closeEmptyElement();
            }
            return xmlStringBuilder;
        }
    }

    public Session() {
        super(ELEMENT, NAMESPACE);
        setType(IQ.Type.set);
    }
}
