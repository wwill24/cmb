package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

public class ReceivedProvider extends ExtensionElementProvider<ChatMarkersElements.ReceivedExtension> {
    public ChatMarkersElements.ReceivedExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new ChatMarkersElements.ReceivedExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
