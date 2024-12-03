package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Mechanisms implements ExtensionElement {
    public static final String ELEMENT = "mechanisms";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", ELEMENT);
    public final List<String> mechanisms;

    public Mechanisms(String str) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.add(str);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public List<String> getMechanisms() {
        return Collections.unmodifiableList(this.mechanisms);
    }

    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-sasl";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        for (String element : this.mechanisms) {
            xmlStringBuilder.element("mechanism", element);
        }
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public Mechanisms(Collection<String> collection) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.addAll(collection);
    }
}
