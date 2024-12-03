package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

public class CryptElementProvider extends OpenPgpContentElementProvider<CryptElement> {
    public static final CryptElementProvider INSTANCE = new CryptElementProvider();

    public CryptElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData parseOpenPgpContentElementData = OpenPgpContentElementProvider.parseOpenPgpContentElementData(xmlPullParser, i10);
        return new CryptElement(parseOpenPgpContentElementData.to, parseOpenPgpContentElementData.rpad, parseOpenPgpContentElementData.timestamp, parseOpenPgpContentElementData.payload);
    }
}
