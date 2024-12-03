package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

public class MarkableProvider extends ExtensionElementProvider<ChatMarkersElements.MarkableExtension> {
    public ChatMarkersElements.MarkableExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return ChatMarkersElements.MarkableExtension.INSTANCE;
    }
}
