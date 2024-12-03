package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriendResponse;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jxmpp.stringprep.XmppStringprepException;

public class IoTIsFriendResponseProvider extends IQProvider<IoTIsFriendResponse> {
    public IoTIsFriendResponse parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new IoTIsFriendResponse(ParserUtils.getJidAttribute(xmlPullParser).i1(), ParserUtils.getBooleanAttribute(xmlPullParser, MamElements.MamResultExtension.ELEMENT).booleanValue());
    }
}
