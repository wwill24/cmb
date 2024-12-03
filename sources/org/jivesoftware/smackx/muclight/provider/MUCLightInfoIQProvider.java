package org.jivesoftware.smackx.muclight.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightInfoIQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;

public class MUCLightInfoIQProvider extends IQProvider<MUCLightInfoIQ> {
    private static HashMap<Jid, MUCLightAffiliation> iterateOccupants(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<Jid, MUCLightAffiliation> hashMap = new HashMap<>();
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("user")) {
                    hashMap.put(a.o(xmlPullParser.nextText()), MUCLightAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation")));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return hashMap;
            }
        }
    }

    public MUCLightInfoIQ parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap<Jid, MUCLightAffiliation> hashMap = new HashMap<>();
        String str = null;
        String str2 = null;
        String str3 = null;
        HashMap hashMap2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    str = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("configuration")) {
                    int depth = xmlPullParser.getDepth();
                    while (true) {
                        XmlPullParser.Event next2 = xmlPullParser.next();
                        if (next2 != XmlPullParser.Event.START_ELEMENT) {
                            if (next2 == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                                break;
                            }
                        } else if (xmlPullParser.getName().equals("roomname")) {
                            str2 = xmlPullParser.nextText();
                        } else if (xmlPullParser.getName().equals(Message.Subject.ELEMENT)) {
                            str3 = xmlPullParser.nextText();
                        } else {
                            if (hashMap2 == null) {
                                hashMap2 = new HashMap();
                            }
                            hashMap2.put(xmlPullParser.getName(), xmlPullParser.nextText());
                        }
                    }
                }
                if (xmlPullParser.getName().equals("occupants")) {
                    hashMap = iterateOccupants(xmlPullParser);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new MUCLightInfoIQ(str, new MUCLightRoomConfiguration(str2, str3, hashMap2), hashMap);
            }
        }
    }
}
