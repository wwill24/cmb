package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;

public class SecretkeyElementProvider extends ExtensionElementProvider<SecretkeyElement> {
    public static final SecretkeyElementProvider TEST_INSTANCE = new SecretkeyElementProvider();

    public SecretkeyElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new SecretkeyElement(xmlPullParser.nextText().getBytes(Charset.forName("UTF-8")));
    }
}
