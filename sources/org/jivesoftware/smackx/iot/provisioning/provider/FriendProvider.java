package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.Friend;
import org.jxmpp.stringprep.XmppStringprepException;

public class FriendProvider extends ExtensionElementProvider<Friend> {
    public Friend parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new Friend(ParserUtils.getBareJidAttribute(xmlPullParser));
    }
}
