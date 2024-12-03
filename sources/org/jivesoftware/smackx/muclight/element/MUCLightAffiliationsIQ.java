package org.jivesoftware.smackx.muclight.element;

import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

public class MUCLightAffiliationsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
    private HashMap<Jid, MUCLightAffiliation> affiliations;
    private final String version;

    public MUCLightAffiliationsIQ(String str, HashMap<Jid, MUCLightAffiliation> hashMap) {
        super("query", "urn:xmpp:muclight:0#affiliations");
        this.version = str;
        this.affiliations = hashMap;
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
        return this.affiliations;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
        for (Map.Entry next : this.affiliations.entrySet()) {
            iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.UserWithAffiliationElement((Jid) next.getKey(), (MUCLightAffiliation) next.getValue()));
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.version;
    }
}
