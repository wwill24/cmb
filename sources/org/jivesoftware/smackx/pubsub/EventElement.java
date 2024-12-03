package org.jivesoftware.smackx.pubsub;

import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

public class EventElement implements EmbeddedPacketExtension {
    public static final String ELEMENT = "event";
    public static final String NAMESPACE;
    public static final QName QNAME;
    private final NodeExtension ext;
    private final EventElementType type;

    static {
        String xmlns = PubSubNamespace.event.getXmlns();
        NAMESPACE = xmlns;
        QNAME = new QName(xmlns, "event");
    }

    public EventElement(EventElementType eventElementType, NodeExtension nodeExtension) {
        this.type = eventElementType;
        this.ext = nodeExtension;
    }

    public static EventElement from(Stanza stanza) {
        return (EventElement) stanza.getExtension(EventElement.class);
    }

    public String getElementName() {
        return "event";
    }

    public NodeExtension getEvent() {
        return this.ext;
    }

    public EventElementType getEventType() {
        return this.type;
    }

    public List<ExtensionElement> getExtensions() {
        return Arrays.asList(new ExtensionElement[]{getEvent()});
    }

    public String getNamespace() {
        return PubSubNamespace.event.getXmlns();
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.ext.toXML());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
