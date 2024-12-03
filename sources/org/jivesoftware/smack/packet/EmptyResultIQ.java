package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

public class EmptyResultIQ extends IQ {
    EmptyResultIQ(IqData iqData) {
        super(iqData, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        return null;
    }

    public EmptyResultIQ() {
        super((String) null, (String) null);
        setType(IQ.Type.result);
    }

    public EmptyResultIQ(IQ iq) {
        this(AbstractIqBuilder.createResponse(iq));
    }
}
