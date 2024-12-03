package org.jivesoftware.smackx.xmlelement.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

public class DataFormsXmlElement implements FormFieldChildElement {
    public static final String ELEMENT = "wrapper";
    public static final String NAMESPACE = "urn:xmpp:xml-element";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final StandardExtensionElement payload;

    public DataFormsXmlElement(StandardExtensionElement standardExtensionElement) {
        this.payload = standardExtensionElement;
    }

    public static DataFormsXmlElement from(FormField formField) {
        return (DataFormsXmlElement) formField.getFormFieldChildElement(QNAME);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public QName getQName() {
        return QNAME;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.payload == null) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.payload.toXML());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
