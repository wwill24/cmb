package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

public class MUCLightBlockingIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#blocking";
    private final HashMap<Jid, Boolean> rooms;
    private final HashMap<Jid, Boolean> users;

    public MUCLightBlockingIQ(HashMap<Jid, Boolean> hashMap, HashMap<Jid, Boolean> hashMap2) {
        super("query", NAMESPACE);
        this.rooms = hashMap;
        this.users = hashMap2;
    }

    private static void parseBlocking(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder, HashMap<Jid, Boolean> hashMap, boolean z10) {
        for (Map.Entry next : hashMap.entrySet()) {
            iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.BlockingElement((Jid) next.getKey(), (Boolean) next.getValue(), Boolean.valueOf(z10)));
        }
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        HashMap<Jid, Boolean> hashMap = this.rooms;
        if (hashMap != null) {
            parseBlocking(iQChildElementXmlStringBuilder, hashMap, true);
        }
        HashMap<Jid, Boolean> hashMap2 = this.users;
        if (hashMap2 != null) {
            parseBlocking(iQChildElementXmlStringBuilder, hashMap2, false);
        }
        return iQChildElementXmlStringBuilder;
    }

    public HashMap<Jid, Boolean> getRooms() {
        return this.rooms;
    }

    public HashMap<Jid, Boolean> getUsers() {
        return this.users;
    }
}
