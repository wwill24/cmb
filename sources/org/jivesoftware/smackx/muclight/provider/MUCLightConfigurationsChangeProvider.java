package org.jivesoftware.smackx.muclight.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;

public class MUCLightConfigurationsChangeProvider extends ExtensionElementProvider<MUCLightElements.ConfigurationsChangeExtension> {
    public MUCLightElements.ConfigurationsChangeExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        HashMap hashMap = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("prev-version")) {
                    str = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    str2 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("roomname")) {
                    str3 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals(Message.Subject.ELEMENT)) {
                    str4 = xmlPullParser.nextText();
                } else {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new MUCLightElements.ConfigurationsChangeExtension(str, str2, str3, str4, hashMap);
            }
        }
    }
}
