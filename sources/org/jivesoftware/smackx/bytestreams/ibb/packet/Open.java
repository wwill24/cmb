package org.jivesoftware.smackx.bytestreams.ibb.packet;

import java.util.Locale;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

public class Open extends IQ {
    public static final String ELEMENT = "open";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final int blockSize;
    private final String sessionID;
    private final InBandBytestreamManager.StanzaType stanza;

    public Open(String str, int i10, InBandBytestreamManager.StanzaType stanzaType) {
        super("open", "http://jabber.org/protocol/ibb");
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        } else if (i10 > 0) {
            this.sessionID = str;
            this.blockSize = i10;
            this.stanza = stanzaType;
            setType(IQ.Type.set);
        } else {
            throw new IllegalArgumentException("Block size must be greater than zero");
        }
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(JingleIBBTransport.ATTR_BLOCK_SIZE, Integer.toString(this.blockSize));
        iQChildElementXmlStringBuilder.attribute("sid", this.sessionID);
        iQChildElementXmlStringBuilder.attribute("stanza", this.stanza.toString().toLowerCase(Locale.US));
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public InBandBytestreamManager.StanzaType getStanza() {
        return this.stanza;
    }

    public Open(String str, int i10) {
        this(str, i10, InBandBytestreamManager.StanzaType.IQ);
    }
}
