package org.jivesoftware.smackx.hashes.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.HashManager;
import org.jivesoftware.smackx.hashes.element.HashElement;

public class HashElementProvider extends ExtensionElementProvider<HashElement> {
    public static final HashElementProvider INSTANCE = new HashElementProvider();

    public HashElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, HashElement.ATTR_ALGO);
        return new HashElement(HashManager.ALGORITHM.valueOfName(attributeValue), xmlPullParser.nextText());
    }
}
