package org.jivesoftware.smackx.bytestreams.ibb.packet;

import org.jivesoftware.smack.packet.IQ;

public class Close extends IQ {
    public static final String ELEMENT = "close";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final String sessionID;

    public Close(String str) {
        super(ELEMENT, "http://jabber.org/protocol/ibb");
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        this.sessionID = str;
        setType(IQ.Type.set);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("sid", this.sessionID);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getSessionID() {
        return this.sessionID;
    }
}
