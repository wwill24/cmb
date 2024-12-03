package org.jivesoftware.smackx.bytestreams.ibb.packet;

import org.jivesoftware.smack.packet.IQ;

public class Data extends IQ {
    private final DataPacketExtension dataPacketExtension;

    public Data(DataPacketExtension dataPacketExtension2) {
        super("data", "http://jabber.org/protocol/ibb");
        if (dataPacketExtension2 != null) {
            this.dataPacketExtension = dataPacketExtension2;
            setType(IQ.Type.set);
            return;
        }
        throw new IllegalArgumentException("Data must not be null");
    }

    public DataPacketExtension getDataPacketExtension() {
        return this.dataPacketExtension;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        return this.dataPacketExtension.getIQChildElementBuilder(iQChildElementXmlStringBuilder);
    }
}
