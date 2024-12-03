package org.jivesoftware.smackx.muclight.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightConfigurationIQ;

public class MUCLightConfigurationIQProvider extends IQProvider<MUCLightConfigurationIQ> {
    public MUCLightConfigurationIQ parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String str = null;
        String str2 = null;
        HashMap hashMap = null;
        String str3 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    str3 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("roomname")) {
                    str = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals(Message.Subject.ELEMENT)) {
                    str2 = xmlPullParser.nextText();
                } else {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new MUCLightConfigurationIQ(str3, new MUCLightRoomConfiguration(str, str2, hashMap));
            }
        }
    }
}
