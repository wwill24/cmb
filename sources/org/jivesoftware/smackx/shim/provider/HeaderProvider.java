package org.jivesoftware.smackx.shim.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.shim.packet.Header;

public class HeaderProvider extends ExtensionElementProvider<Header> {
    public Header parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String str = null;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "name");
        xmlPullParser.next();
        if (xmlPullParser.getEventType() == XmlPullParser.Event.TEXT_CHARACTERS) {
            str = xmlPullParser.getText();
        }
        while (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT) {
            xmlPullParser.next();
        }
        return new Header(attributeValue, str);
    }
}
