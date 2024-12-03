package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public final class SaslChallengeProvider extends NonzaProvider<SaslNonza.Challenge> {
    public static final SaslChallengeProvider INSTANCE = new SaslChallengeProvider();

    private SaslChallengeProvider() {
    }

    public SaslNonza.Challenge parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException {
        return new SaslNonza.Challenge(xmlPullParser.nextText());
    }
}
