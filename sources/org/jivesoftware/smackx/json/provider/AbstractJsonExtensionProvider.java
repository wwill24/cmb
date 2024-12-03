package org.jivesoftware.smackx.json.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.json.packet.AbstractJsonPacketExtension;

public abstract class AbstractJsonExtensionProvider<J extends AbstractJsonPacketExtension> extends ExtensionElementProvider<J> {
    public abstract J from(String str);

    public J parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return from(PacketParserUtils.parseElementText(xmlPullParser));
    }
}
