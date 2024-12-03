package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.Jid;

public class IoTClaimed extends IQ {
    public static final String ELEMENT = "claimed";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final Jid jid;
    private final NodeInfo nodeInfo;

    public IoTClaimed(Jid jid2) {
        this(jid2, NodeInfo.EMPTY);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public Jid getJid() {
        return this.jid;
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

    public IoTClaimed(Jid jid2, NodeInfo nodeInfo2) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.jid = jid2;
        this.nodeInfo = nodeInfo2;
    }
}
