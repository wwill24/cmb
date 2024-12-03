package org.jivesoftware.smackx.last_interaction.provider;

import java.text.ParseException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;
import org.jxmpp.util.XmppDateTime;

public class IdleProvider extends ExtensionElementProvider<IdleElement> {
    public static final IdleProvider TEST_INSTANCE = new IdleProvider();

    public IdleElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException {
        try {
            return new IdleElement(XmppDateTime.m(xmlPullParser.getAttributeValue((String) null, IdleElement.ATTR_SINCE)));
        } catch (ParseException e10) {
            throw new SmackParsingException.SmackTextParseException(e10);
        }
    }
}
