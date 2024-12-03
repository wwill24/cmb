package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

public abstract class SimpleIQ extends IQ {
    protected SimpleIQ(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    protected SimpleIQ(IqData iqData, String str, String str2) {
        super(iqData, str, str2);
    }
}
