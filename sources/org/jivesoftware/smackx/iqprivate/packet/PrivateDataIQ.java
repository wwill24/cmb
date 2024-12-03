package org.jivesoftware.smackx.iqprivate.packet;

import org.jivesoftware.smack.packet.IQ;

public class PrivateDataIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:private";
    private final String getElement;
    private final String getNamespace;
    private final PrivateData privateData;

    public PrivateDataIQ(PrivateData privateData2) {
        this(privateData2, (String) null, (String) null);
        setType(IQ.Type.set);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        PrivateData privateData2 = this.privateData;
        if (privateData2 != null) {
            iQChildElementXmlStringBuilder.append(privateData2.toXML());
        } else {
            iQChildElementXmlStringBuilder.halfOpenElement(this.getElement).xmlnsAttribute(this.getNamespace).closeEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public PrivateData getPrivateData() {
        return this.privateData;
    }

    public PrivateDataIQ(String str, String str2) {
        this((PrivateData) null, str, str2);
        setType(IQ.Type.get);
    }

    private PrivateDataIQ(PrivateData privateData2, String str, String str2) {
        super("query", NAMESPACE);
        this.privateData = privateData2;
        this.getElement = str;
        this.getNamespace = str2;
    }
}
