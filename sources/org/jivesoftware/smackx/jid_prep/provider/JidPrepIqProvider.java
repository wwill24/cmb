package org.jivesoftware.smackx.jid_prep.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jid_prep.element.JidPrepIq;

public class JidPrepIqProvider extends IQProvider<JidPrepIq> {
    public JidPrepIq parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new JidPrepIq(xmlPullParser.nextText());
    }
}
