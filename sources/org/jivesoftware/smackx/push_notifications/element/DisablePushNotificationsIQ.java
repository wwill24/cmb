package org.jivesoftware.smackx.push_notifications.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

public class DisablePushNotificationsIQ extends IQ {
    public static final String ELEMENT = "disable";
    public static final String NAMESPACE = "urn:xmpp:push:0";
    private final Jid jid;
    private final String node;

    public DisablePushNotificationsIQ(Jid jid2, String str) {
        super("disable", "urn:xmpp:push:0");
        this.jid = jid2;
        this.node = str;
        setType(IQ.Type.set);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNode() {
        return this.node;
    }

    public DisablePushNotificationsIQ(Jid jid2) {
        this(jid2, (String) null);
    }
}
