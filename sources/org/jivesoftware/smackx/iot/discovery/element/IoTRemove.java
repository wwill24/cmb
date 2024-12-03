package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

public class IoTRemove extends IQ {
    public static final String ELEMENT = "remove";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final BareJid jid;
    private final NodeInfo nodeInfo;

    public IoTRemove(BareJid bareJid) {
        this(bareJid, NodeInfo.EMPTY);
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
        NodeInfo nodeInfo2 = this.nodeInfo;
        if (nodeInfo2 != null) {
            return nodeInfo2.getNodeId();
        }
        return null;
    }

    public String getSourceId() {
        NodeInfo nodeInfo2 = this.nodeInfo;
        if (nodeInfo2 != null) {
            return nodeInfo2.getSourceId();
        }
        return null;
    }

    public IoTRemove(BareJid bareJid, NodeInfo nodeInfo2) {
        super("remove", "urn:xmpp:iot:discovery");
        this.jid = bareJid;
        this.nodeInfo = nodeInfo2;
    }
}
