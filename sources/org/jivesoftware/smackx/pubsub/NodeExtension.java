package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

public class NodeExtension implements ExtensionElement {
    private final PubSubElementType element;
    private final String node;

    public NodeExtension(PubSubElementType pubSubElementType, String str) {
        this.element = pubSubElementType;
        this.node = str;
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.closeEmptyElement();
    }

    public String getElementName() {
        return this.element.getElementName();
    }

    public final String getNamespace() {
        return getPubSubNamespace().getXmlns();
    }

    public String getNode() {
        return this.node;
    }

    public PubSubNamespace getPubSubNamespace() {
        return this.element.getNamespace();
    }

    public String toString() {
        return getClass().getName() + " - content [" + toXML() + "]";
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        addXml(xmlStringBuilder);
        return xmlStringBuilder;
    }

    public NodeExtension(PubSubElementType pubSubElementType) {
        this(pubSubElementType, (String) null);
    }
}
