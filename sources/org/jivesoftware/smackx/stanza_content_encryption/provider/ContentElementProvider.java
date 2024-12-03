package org.jivesoftware.smackx.stanza_content_encryption.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.stanza_content_encryption.element.AffixElement;
import org.jivesoftware.smackx.stanza_content_encryption.element.ContentElement;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class ContentElementProvider extends ExtensionElementProvider<ContentElement> {
    private static void parseCustomAffix(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, ContentElement.Builder builder) throws XmlPullParserException, IOException, SmackParsingException {
        builder.addFurtherAffixElement((AffixElement) PacketParserUtils.parseExtensionElement(xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlPullParser, xmlEnvironment));
    }

    private static void parseFromAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws XmppStringprepException {
        builder.setFrom(a.o(xmlPullParser.getAttributeValue("", "jid")));
    }

    private static void parsePayload(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, ContentElement.Builder builder) throws IOException, XmlPullParserException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                builder.addPayloadItem(PacketParserUtils.parseExtensionElement(xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlPullParser, xmlEnvironment));
            }
            if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseRPadAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws IOException, XmlPullParserException {
        builder.setRandomPadding(xmlPullParser.nextText());
    }

    private static void parseTimestampAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws SmackParsingException.SmackTextParseException {
        builder.setTimestamp(ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue("", "stamp")));
    }

    private static void parseToAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws XmppStringprepException {
        builder.addTo(a.o(xmlPullParser.getAttributeValue("", "jid")));
    }

    public ContentElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ContentElement.Builder builder = ContentElement.builder();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                char c10 = 65535;
                switch (name.hashCode()) {
                    case -786701938:
                        if (name.equals("payload")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3707:
                        if (name.equals("to")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3151786:
                        if (name.equals("from")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3506913:
                        if (name.equals("rpad")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3560141:
                        if (name.equals("time")) {
                            c10 = 4;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        parsePayload(xmlPullParser, xmlEnvironment, builder);
                        break;
                    case 1:
                        parseToAffix(xmlPullParser, builder);
                        break;
                    case 2:
                        parseFromAffix(xmlPullParser, builder);
                        break;
                    case 3:
                        parseRPadAffix(xmlPullParser, builder);
                        break;
                    case 4:
                        parseTimestampAffix(xmlPullParser, builder);
                        break;
                    default:
                        parseCustomAffix(xmlPullParser, xmlEnvironment, builder);
                        break;
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return builder.build();
            }
        }
    }
}
