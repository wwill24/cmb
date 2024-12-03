package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public final class SaslSuccessProvider extends NonzaProvider<SaslNonza.Success> {
    public static final SaslSuccessProvider INSTANCE = new SaslSuccessProvider();

    private SaslSuccessProvider() {
    }

    public SaslNonza.Success parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException {
        return new SaslNonza.Success(xmlPullParser.nextText());
    }
}
