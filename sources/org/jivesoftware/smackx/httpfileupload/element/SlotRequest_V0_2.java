package org.jivesoftware.smackx.httpfileupload.element;

import com.leanplum.internal.Constants;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.DomainBareJid;

public class SlotRequest_V0_2 extends SlotRequest {
    public static final String NAMESPACE = "urn:xmpp:http:upload";

    public SlotRequest_V0_2(DomainBareJid domainBareJid, String str, long j10) {
        this(domainBareJid, str, j10, (String) null);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.element(Constants.Keys.FILENAME, this.filename);
        iQChildElementXmlStringBuilder.element("size", String.valueOf(this.size));
        iQChildElementXmlStringBuilder.optElement("content-type", this.contentType);
        return iQChildElementXmlStringBuilder;
    }

    public SlotRequest_V0_2(DomainBareJid domainBareJid, String str, long j10, String str2) {
        super(domainBareJid, str, j10, str2, "urn:xmpp:http:upload");
    }
}
