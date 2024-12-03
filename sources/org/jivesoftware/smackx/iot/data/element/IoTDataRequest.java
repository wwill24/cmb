package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.IQ;

public class IoTDataRequest extends IQ {
    public static final String ELEMENT = "req";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    private final boolean momentary;
    private final int seqNr;

    public IoTDataRequest(int i10, boolean z10) {
        super("req", "urn:xmpp:iot:sensordata");
        this.seqNr = i10;
        this.momentary = z10;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seqnr", this.seqNr);
        iQChildElementXmlStringBuilder.optBooleanAttribute("momentary", this.momentary);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public int getSequenceNr() {
        return this.seqNr;
    }

    public boolean isMomentary() {
        return this.momentary;
    }
}
