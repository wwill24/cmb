package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.util.Date;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.PubkeyElement;

public class PubkeyElementProvider extends ExtensionElementProvider<PubkeyElement> {
    public static final PubkeyElementProvider INSTANCE = new PubkeyElementProvider();

    public PubkeyElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException.SmackTextParseException {
        Date dateFromOptionalXep82String = ParserUtils.getDateFromOptionalXep82String(xmlPullParser.getAttributeValue((String) null, "date"));
        while (true) {
            if (xmlPullParser.next() == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("data")) {
                    return new PubkeyElement(new PubkeyElement.PubkeyDataElement(xmlPullParser.nextText()), dateFromOptionalXep82String);
                }
            }
        }
    }
}
