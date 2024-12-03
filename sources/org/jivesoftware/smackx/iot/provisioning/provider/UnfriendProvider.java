package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.Unfriend;
import org.jxmpp.stringprep.XmppStringprepException;

public class UnfriendProvider extends ExtensionElementProvider<Unfriend> {
    public Unfriend parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new Unfriend(ParserUtils.getBareJidAttribute(xmlPullParser));
    }
}
