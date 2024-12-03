package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

public class SignElementProvider extends OpenPgpContentElementProvider<SignElement> {
    public static final SignElementProvider INSTANCE = new SignElementProvider();
    private static final Logger LOGGER = Logger.getLogger(SigncryptElementProvider.class.getName());

    public SignElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData parseOpenPgpContentElementData = OpenPgpContentElementProvider.parseOpenPgpContentElementData(xmlPullParser, i10);
        if (StringUtils.isNotEmpty((CharSequence) parseOpenPgpContentElementData.rpad)) {
            LOGGER.warning("Ignoring rpad in XEP-0373 <sign/> element");
        }
        return new SignElement(parseOpenPgpContentElementData.to, parseOpenPgpContentElementData.timestamp, parseOpenPgpContentElementData.payload);
    }
}
