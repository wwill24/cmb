package org.jivesoftware.smackx.carbons.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;

public class CarbonManagerProvider extends ExtensionElementProvider<CarbonExtension> {
    public CarbonExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        CarbonExtension.Direction valueOf = CarbonExtension.Direction.valueOf(xmlPullParser.getName());
        Forwarded<Message> forwarded = null;
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals(Forwarded.ELEMENT)) {
                forwarded = ForwardedProvider.parseForwardedMessage(xmlPullParser, xmlEnvironment);
            } else if (next == XmlPullParser.Event.END_ELEMENT && valueOf == CarbonExtension.Direction.valueOf(xmlPullParser.getName())) {
                z10 = true;
            }
        }
        if (forwarded != null) {
            return new CarbonExtension(valueOf, forwarded);
        }
        throw new SmackParsingException("sent/received must contain exactly one <forwarded/> element");
    }
}
