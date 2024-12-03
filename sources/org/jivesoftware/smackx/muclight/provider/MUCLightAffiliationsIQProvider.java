package org.jivesoftware.smackx.muclight.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightAffiliationsIQ;
import org.jxmpp.jid.impl.a;

public class MUCLightAffiliationsIQProvider extends IQProvider<MUCLightAffiliationsIQ> {
    public MUCLightAffiliationsIQ parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        String str = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    str = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("user")) {
                    hashMap.put(a.o(xmlPullParser.nextText()), MUCLightAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation")));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new MUCLightAffiliationsIQ(str, hashMap);
            }
        }
    }
}
