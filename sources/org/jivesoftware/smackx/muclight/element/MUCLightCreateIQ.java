package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

public class MUCLightCreateIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#create";
    private MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;

    public MUCLightCreateIQ(EntityJid entityJid, String str, String str2, HashMap<String, String> hashMap, List<Jid> list) {
        super("query", NAMESPACE);
        this.configuration = new MUCLightRoomConfiguration(str, str2, hashMap);
        this.occupants = new HashMap<>();
        for (Jid put : list) {
            this.occupants.put(put, MUCLightAffiliation.member);
        }
        setType(IQ.Type.set);
        setTo(entityJid);
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.ConfigurationElement(this.configuration));
        if (!this.occupants.isEmpty()) {
            iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.OccupantsElement(this.occupants));
        }
        return iQChildElementXmlStringBuilder;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }

    public MUCLightCreateIQ(EntityJid entityJid, String str, List<Jid> list) {
        this(entityJid, str, (String) null, (HashMap<String, String>) null, list);
    }
}
