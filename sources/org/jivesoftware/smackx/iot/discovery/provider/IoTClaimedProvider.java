package org.jivesoftware.smackx.iot.discovery.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTClaimed;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.stringprep.XmppStringprepException;

public class IoTClaimedProvider extends IQProvider<IoTClaimed> {
    public IoTClaimed parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new IoTClaimed(ParserUtils.getJidAttribute(xmlPullParser), NodeInfoParser.parse(xmlPullParser));
    }
}
