package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.jid.Jid;

public class MUCLightSetConfigsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
    private HashMap<String, String> customConfigs;
    private String roomName;
    private String subject;

    public MUCLightSetConfigsIQ(Jid jid, String str, String str2, HashMap<String, String> hashMap) {
        super("query", "urn:xmpp:muclight:0#configuration");
        this.roomName = str;
        this.subject = str2;
        this.customConfigs = hashMap;
        setType(IQ.Type.set);
        setTo(jid);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("roomname", this.roomName);
        iQChildElementXmlStringBuilder.optElement(Message.Subject.ELEMENT, this.subject);
        HashMap<String, String> hashMap = this.customConfigs;
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                iQChildElementXmlStringBuilder.element((String) next.getKey(), (String) next.getValue());
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public MUCLightSetConfigsIQ(Jid jid, String str, HashMap<String, String> hashMap) {
        this(jid, str, (String) null, hashMap);
    }
}
