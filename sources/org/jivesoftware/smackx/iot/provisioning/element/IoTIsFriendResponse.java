package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jxmpp.jid.BareJid;

public class IoTIsFriendResponse extends IQ {
    public static final String ELEMENT = "isFriendResponse";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    private final BareJid jid;
    private final boolean result;

    public IoTIsFriendResponse(BareJid bareJid, boolean z10) {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        this.jid = bareJid;
        this.result = z10;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        iQChildElementXmlStringBuilder.attribute(MamElements.MamResultExtension.ELEMENT, this.result);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public boolean getIsFriendResult() {
        return this.result;
    }

    public BareJid getJid() {
        return this.jid;
    }
}
