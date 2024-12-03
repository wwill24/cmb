package org.jivesoftware.smackx.fallback_indication.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

public class FallbackIndicationElementProvider extends ExtensionElementProvider<FallbackIndicationElement> {
    public FallbackIndicationElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return FallbackIndicationElement.INSTANCE;
    }
}
