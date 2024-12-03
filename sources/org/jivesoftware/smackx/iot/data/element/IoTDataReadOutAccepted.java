package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.IQ;

public class IoTDataReadOutAccepted extends IQ {
    public static final String ELEMENT = "accepted";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    private final boolean queued;
    private final int seqNr;

    public IoTDataReadOutAccepted(int i10, boolean z10) {
        super(ELEMENT, "urn:xmpp:iot:sensordata");
        this.seqNr = i10;
        this.queued = z10;
        setType(IQ.Type.result);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seqnr", this.seqNr);
        iQChildElementXmlStringBuilder.optBooleanAttribute("queued", this.queued);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public IoTDataReadOutAccepted(IoTDataRequest ioTDataRequest) {
        this(ioTDataRequest.getSequenceNr(), false);
        setStanzaId(ioTDataRequest.getStanzaId());
        setTo(ioTDataRequest.getFrom());
    }
}
