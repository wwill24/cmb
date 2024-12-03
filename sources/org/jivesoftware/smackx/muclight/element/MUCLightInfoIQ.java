package org.jivesoftware.smackx.muclight.element;

import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.Jid;

public class MUCLightInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#info";
    private final MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;
    private final String version;

    public MUCLightInfoIQ(String str, MUCLightRoomConfiguration mUCLightRoomConfiguration, HashMap<Jid, MUCLightAffiliation> hashMap) {
        super("query", "urn:xmpp:muclight:0#info");
        this.version = str;
        this.configuration = mUCLightRoomConfiguration;
        this.occupants = hashMap;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
        iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.ConfigurationElement(this.configuration));
        iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.OccupantsElement(this.occupants));
        return iQChildElementXmlStringBuilder;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }

    public String getVersion() {
        return this.version;
    }
}
