package org.jivesoftware.smackx.jingle.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

public abstract class JingleContentTransportProvider<T extends JingleContentTransport> extends ExtensionElementProvider<T> {
    public abstract T parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException;
}
