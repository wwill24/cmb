package org.jivesoftware.smackx.chatstates.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;

public class ChatStateExtensionProvider extends ExtensionElementProvider<ChatStateExtension> {
    public ChatStateExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new ChatStateExtension(ChatState.valueOf(xmlPullParser.getName()));
    }
}
