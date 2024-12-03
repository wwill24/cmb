package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public class SubscribeExtension extends NodeExtension {
    protected final Jid jid;

    public SubscribeExtension(Jid jid2) {
        super(PubSubElementType.SUBSCRIBE);
        this.jid = jid2;
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", (CharSequence) getJid());
        xmlStringBuilder.closeEmptyElement();
    }

    public Jid getJid() {
        return this.jid;
    }

    public SubscribeExtension(Jid jid2, String str) {
        super(PubSubElementType.SUBSCRIBE, str);
        this.jid = jid2;
    }
}
