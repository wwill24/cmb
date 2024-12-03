package org.jivesoftware.smackx.nick.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.nick.packet.Nick;

public class NickProvider extends ExtensionElementProvider<Nick> {
    public Nick parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new Nick(xmlPullParser.nextText());
    }
}
