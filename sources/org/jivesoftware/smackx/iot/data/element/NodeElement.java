package org.jivesoftware.smackx.iot.data.element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public class NodeElement extends IoTDataExtensionElement {
    public static final String ELEMENT = "node";
    private final NodeInfo nodeInfo;
    private final List<TimestampElement> timestampElements;

    public NodeElement(NodeInfo nodeInfo2, TimestampElement timestampElement) {
        this(nodeInfo2, (List<TimestampElement>) Collections.singletonList(timestampElement));
    }

    public String getElementName() {
        return ELEMENT;
    }

    public List<TimestampElement> getTimestampElements() {
        return this.timestampElements;
    }

    public NodeElement(NodeInfo nodeInfo2, List<TimestampElement> list) {
        this.nodeInfo = nodeInfo2;
        this.timestampElements = Collections.unmodifiableList(list);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        this.nodeInfo.appendTo(xmlStringBuilder);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.timestampElements);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
