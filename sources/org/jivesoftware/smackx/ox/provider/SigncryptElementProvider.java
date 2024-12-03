package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

public class SigncryptElementProvider extends OpenPgpContentElementProvider<SigncryptElement> {
    public static final SigncryptElementProvider INSTANCE = new SigncryptElementProvider();

    public SigncryptElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData parseOpenPgpContentElementData = OpenPgpContentElementProvider.parseOpenPgpContentElementData(xmlPullParser, i10);
        return new SigncryptElement(parseOpenPgpContentElementData.to, parseOpenPgpContentElementData.rpad, parseOpenPgpContentElementData.timestamp, parseOpenPgpContentElementData.payload);
    }
}
