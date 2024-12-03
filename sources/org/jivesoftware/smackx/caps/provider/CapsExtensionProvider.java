package org.jivesoftware.smackx.caps.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

public class CapsExtensionProvider extends ExtensionElementProvider<CapsExtension> {
    public CapsExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != XmlPullParser.Event.START_ELEMENT || !xmlPullParser.getName().equalsIgnoreCase("c")) {
            throw new IOException("Malformed Caps element");
        }
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "hash");
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, RosterVer.ELEMENT);
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, NodeElement.ELEMENT);
        xmlPullParser.next();
        if (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT || !xmlPullParser.getName().equalsIgnoreCase("c")) {
            throw new IOException("Malformed nested Caps element");
        } else if (attributeValue != null && attributeValue2 != null && attributeValue3 != null) {
            return new CapsExtension(attributeValue3, attributeValue2, attributeValue);
        } else {
            throw new IOException("Caps element with missing attributes. Attributes: hash=" + attributeValue + " version=" + attributeValue2 + " node=" + attributeValue3);
        }
    }
}
