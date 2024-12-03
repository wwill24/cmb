package org.jivesoftware.smackx.muclight.element;

import com.facebook.internal.ServerProtocol;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;

public class MUCLightConfigurationIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
    private final MUCLightRoomConfiguration configuration;
    private final String version;

    public MUCLightConfigurationIQ(String str, MUCLightRoomConfiguration mUCLightRoomConfiguration) {
        super("query", "urn:xmpp:muclight:0#configuration");
        this.version = str;
        this.configuration = mUCLightRoomConfiguration;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
        iQChildElementXmlStringBuilder.append((Element) new MUCLightElements.ConfigurationElement(this.configuration));
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.version;
    }
}
