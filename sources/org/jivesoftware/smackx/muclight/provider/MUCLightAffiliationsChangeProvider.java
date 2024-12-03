package org.jivesoftware.smackx.muclight.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.impl.a;

public class MUCLightAffiliationsChangeProvider extends ExtensionElementProvider<MUCLightElements.AffiliationsChangeExtension> {
    public MUCLightElements.AffiliationsChangeExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        String str = null;
        String str2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("prev-version")) {
                    str = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    str2 = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("user")) {
                    hashMap.put(a.o(xmlPullParser.nextText()), MUCLightAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation")));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return new MUCLightElements.AffiliationsChangeExtension(hashMap, str, str2);
            }
        }
    }
}
