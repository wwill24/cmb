package org.jivesoftware.smackx.iot.data.element;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public class IoTFieldsExtension implements ExtensionElement {
    public static final String ELEMENT = "fields";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    public static final QName QNAME = new QName("urn:xmpp:iot:sensordata", "fields");
    private final boolean done;
    private final List<NodeElement> nodes;
    private final int seqNr;

    public IoTFieldsExtension(int i10, boolean z10, NodeElement nodeElement) {
        this(i10, z10, (List<NodeElement>) Collections.singletonList(nodeElement));
    }

    public static IoTFieldsExtension buildFor(int i10, boolean z10, NodeInfo nodeInfo, List<? extends IoTDataField> list) {
        return new IoTFieldsExtension(i10, z10, new NodeElement(nodeInfo, new TimestampElement(new Date(), list)));
    }

    public static IoTFieldsExtension from(Message message) {
        return (IoTFieldsExtension) message.getExtension(IoTFieldsExtension.class);
    }

    public String getElementName() {
        return "fields";
    }

    public String getNamespace() {
        return "urn:xmpp:iot:sensordata";
    }

    public List<NodeElement> getNodes() {
        return this.nodes;
    }

    public int getSequenceNr() {
        return this.seqNr;
    }

    public boolean isDone() {
        return this.done;
    }

    public IoTFieldsExtension(int i10, boolean z10, List<NodeElement> list) {
        this.seqNr = i10;
        this.done = z10;
        this.nodes = Collections.unmodifiableList(list);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("seqnr", Integer.toString(this.seqNr));
        xmlStringBuilder.attribute("done", this.done);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.nodes);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
