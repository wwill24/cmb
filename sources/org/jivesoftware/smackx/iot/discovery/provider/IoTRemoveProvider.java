package org.jivesoftware.smackx.iot.discovery.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemove;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.jid.Jid;

public class IoTRemoveProvider extends IQProvider<IoTRemove> {
    public IoTRemove parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException {
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        if (!jidAttribute.R1()) {
            return new IoTRemove(jidAttribute.i1(), NodeInfoParser.parse(xmlPullParser));
        }
        throw new IOException("JID must be without resourcepart");
    }
}
