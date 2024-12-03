package org.jivesoftware.smackx.httpfileupload.element;

import com.leanplum.internal.Constants;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.DomainBareJid;

public class SlotRequest extends IQ {
    public static final String ELEMENT = "request";
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    protected final String contentType;
    protected final String filename;
    protected final long size;

    public SlotRequest(DomainBareJid domainBareJid, String str, long j10) {
        this(domainBareJid, str, j10, (String) null);
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFilename() {
        return this.filename;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(Constants.Keys.FILENAME, this.filename);
        iQChildElementXmlStringBuilder.attribute("size", String.valueOf(this.size));
        iQChildElementXmlStringBuilder.optAttribute("content-type", this.contentType);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public long getSize() {
        return this.size;
    }

    public SlotRequest(DomainBareJid domainBareJid, String str, long j10, String str2) {
        this(domainBareJid, str, j10, str2, "urn:xmpp:http:upload:0");
    }

    protected SlotRequest(DomainBareJid domainBareJid, String str, long j10, String str2, String str3) {
        super("request", str3);
        if (j10 > 0) {
            this.filename = str;
            this.size = j10;
            this.contentType = str2;
            setType(IQ.Type.get);
            setTo(domainBareJid);
            return;
        }
        throw new IllegalArgumentException("File fileSize must be greater than zero.");
    }
}
