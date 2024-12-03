package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

public class DisplayedProvider extends ExtensionElementProvider<ChatMarkersElements.DisplayedExtension> {
    public ChatMarkersElements.DisplayedExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new ChatMarkersElements.DisplayedExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
