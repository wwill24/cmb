package org.jivesoftware.smackx.jid_prep.element;

import org.jivesoftware.smack.packet.IQ;

public class JidPrepIq extends IQ {
    public static final String ELEMENT = "jid";
    public static final String NAMESPACE = "urn:xmpp:jidprep:0";
    private final String jid;

    public JidPrepIq(String str) {
        super("jid", "urn:xmpp:jidprep:0");
        this.jid = str;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.escape(this.jid);
        return iQChildElementXmlStringBuilder;
    }

    public String getJid() {
        return this.jid;
    }
}
