package org.jivesoftware.smackx.message_fastening.element;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class ExternalElement implements NamedElement {
    public static final String ATTR_ELEMENT_NAMESPACE = "element-namespace";
    public static final String ATTR_NAME = "name";
    public static final String ELEMENT = "external";
    private final String elementNamespace;
    private final String name;

    public ExternalElement(String str) {
        this(str, (String) null);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getElementNamespace() {
        return this.elementNamespace;
    }

    public String getName() {
        return this.name;
    }

    public ExternalElement(String str, String str2) {
        this.name = str;
        this.elementNamespace = str2;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.attribute("name", getName());
        xmlStringBuilder.optAttribute(ATTR_ELEMENT_NAMESPACE, getElementNamespace());
        return xmlStringBuilder.closeEmptyElement();
    }
}
