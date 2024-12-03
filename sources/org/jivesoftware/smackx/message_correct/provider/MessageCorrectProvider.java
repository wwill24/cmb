package org.jivesoftware.smackx.message_correct.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.message_correct.element.MessageCorrectExtension;

public class MessageCorrectProvider extends ExtensionElementProvider<MessageCorrectExtension> {
    public MessageCorrectExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new MessageCorrectExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
