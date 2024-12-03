package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

public class MUCLightChangeAffiliationsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
    private HashMap<Jid, MUCLightAffiliation> affiliations;

    public MUCLightChangeAffiliationsIQ(Jid jid, HashMap<Jid, MUCLightAffiliation> hashMap) {
        super("query", "urn:xmpp:muclight:0#affiliations");
        setType(IQ.Type.set);
        setTo(jid);
        this.affiliations = hashMap;
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
        return this.affiliations;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        HashMap<Jid, MUCLightAffiliation> hashMap = this.affiliations;
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.UserWithAffiliationElement((Jid) next.getKey(), (MUCLightAffiliation) next.getValue()));
            }
        }
        return iQChildElementXmlStringBuilder;
    }
}
