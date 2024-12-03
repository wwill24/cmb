package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.element.MUCLightBlockingIQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class MUCLightBlockingIQProvider extends IQProvider<MUCLightBlockingIQ> {
    private static HashMap<Jid, Boolean> parseBlocking(XmlPullParser xmlPullParser, HashMap<Jid, Boolean> hashMap) throws XmppStringprepException, XmlPullParserException, IOException {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue.equals("deny")) {
            hashMap.put(a.o(xmlPullParser.nextText()), Boolean.FALSE);
        } else if (attributeValue.equals("allow")) {
            hashMap.put(a.o(xmlPullParser.nextText()), Boolean.TRUE);
        }
        return hashMap;
    }

    public MUCLightBlockingIQ parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap<Jid, Boolean> hashMap = null;
        HashMap<Jid, Boolean> hashMap2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("room")) {
                    hashMap = parseBlocking(xmlPullParser, hashMap);
                }
                if (xmlPullParser.getName().equals("user")) {
                    hashMap2 = parseBlocking(xmlPullParser, hashMap2);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(hashMap, hashMap2);
                mUCLightBlockingIQ.setType(IQ.Type.result);
                return mUCLightBlockingIQ;
            }
        }
    }
}
