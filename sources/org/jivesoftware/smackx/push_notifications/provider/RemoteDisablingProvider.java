package org.jivesoftware.smackx.push_notifications.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;

public class RemoteDisablingProvider extends ExtensionElementProvider<PushNotificationsElements.RemoteDisablingExtension> {
    public PushNotificationsElements.RemoteDisablingExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue;
        String attributeValue2 = xmlPullParser.getAttributeValue("", NodeElement.ELEMENT);
        Jid jid = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("affiliation")) {
                    jid = a.o(xmlPullParser.getAttributeValue("", "jid"));
                    attributeValue = xmlPullParser.getAttributeValue("", "affiliation");
                    if (attributeValue == null || !attributeValue.equals("none")) {
                    }
                } else {
                    continue;
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new PushNotificationsElements.RemoteDisablingExtension(attributeValue2, jid);
            }
        }
        throw new IOException("Invalid affiliation: " + attributeValue);
    }
}
