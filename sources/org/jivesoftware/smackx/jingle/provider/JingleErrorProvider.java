package org.jivesoftware.smackx.jingle.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.jingle.element.JingleError;

public class JingleErrorProvider extends ExtensionElementProvider<JingleError> {
    public JingleError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return JingleError.fromString(xmlPullParser.getName());
    }
}
