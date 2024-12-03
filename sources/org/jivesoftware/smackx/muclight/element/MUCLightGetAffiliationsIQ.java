package org.jivesoftware.smackx.muclight.element;

import com.facebook.internal.ServerProtocol;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

public class MUCLightGetAffiliationsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
    private String version;

    public MUCLightGetAffiliationsIQ(Jid jid, String str) {
        super("query", "urn:xmpp:muclight:0#affiliations");
        this.version = str;
        setType(IQ.Type.get);
        setTo(jid);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
        return iQChildElementXmlStringBuilder;
    }

    public MUCLightGetAffiliationsIQ(Jid jid) {
        this(jid, (String) null);
    }
}
