package org.jivesoftware.smackx.hoxt.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;

public class Base64BinaryChunkProvider extends ExtensionElementProvider<Base64BinaryChunk> {
    public Base64BinaryChunk parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", Base64BinaryChunk.ATTRIBUTE_STREAM_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", Base64BinaryChunk.ATTRIBUTE_NR);
        String attributeValue3 = xmlPullParser.getAttributeValue("", Base64BinaryChunk.ATTRIBUTE_LAST);
        int parseInt = Integer.parseInt(attributeValue2);
        boolean z10 = false;
        boolean parseBoolean = attributeValue3 != null ? Boolean.parseBoolean(attributeValue3) : false;
        String str = null;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (xmlPullParser.getName().equals(Base64BinaryChunk.ELEMENT_CHUNK)) {
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                str = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new Base64BinaryChunk(str, attributeValue, parseInt, parseBoolean);
    }
}
