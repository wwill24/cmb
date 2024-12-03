package org.jivesoftware.smackx.sid.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;

public class StanzaIdProvider extends ExtensionElementProvider<StanzaIdElement> {
    public static final StanzaIdProvider INSTANCE = new StanzaIdProvider();

    public StanzaIdElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new StanzaIdElement(xmlPullParser.getAttributeValue((String) null, "id"), xmlPullParser.getAttributeValue((String) null, StanzaIdElement.ATTR_BY));
    }
}
