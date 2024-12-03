package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.jid.Jid;

public class SubscriptionProvider extends ExtensionElementProvider<Subscription> {
    public Subscription parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        Subscription.State state = null;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, NodeElement.ELEMENT);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "subid");
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "subscription");
        XmlPullParser.Event next = xmlPullParser.next();
        XmlPullParser.Event event = XmlPullParser.Event.START_ELEMENT;
        boolean z10 = false;
        if (next == event && xmlPullParser.getName().equals("subscribe-options")) {
            XmlPullParser.Event next2 = xmlPullParser.next();
            if (next2 == event && xmlPullParser.getName().equals(FormField.Required.ELEMENT)) {
                z10 = true;
            }
            while (next2 != XmlPullParser.Event.END_ELEMENT && !xmlPullParser.getName().equals("subscribe-options")) {
                next2 = xmlPullParser.next();
            }
        }
        while (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT) {
            xmlPullParser.next();
        }
        if (attributeValue3 != null) {
            state = Subscription.State.valueOf(attributeValue3);
        }
        return new Subscription(jidAttribute, attributeValue, attributeValue2, state, z10);
    }
}
