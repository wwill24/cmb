package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public class IoTRemoved extends IQ {
    public static final String ELEMENT = "removed";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final NodeInfo nodeInfo;

    public IoTRemoved() {
        this(NodeInfo.EMPTY);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getNodeId() {
        return this.nodeInfo.getNodeId();
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public String getSourceId() {
        return this.nodeInfo.getSourceId();
    }

    public IoTRemoved(NodeInfo nodeInfo2) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.nodeInfo = nodeInfo2;
    }
}
