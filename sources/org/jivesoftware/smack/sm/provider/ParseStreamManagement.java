package org.jivesoftware.smack.sm.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaErrorTextElement;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class ParseStreamManagement {

    /* renamed from: org.jivesoftware.smack.sm.provider.ParseStreamManagement$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.sm.provider.ParseStreamManagement.AnonymousClass1.<clinit>():void");
        }
    }

    public static StreamManagement.AckAnswer ackAnswer(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long longValue = ParserUtils.getLongAttribute(xmlPullParser, "h").longValue();
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.AckAnswer(longValue);
    }

    public static StreamManagement.AckRequest ackRequest(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return StreamManagement.AckRequest.INSTANCE;
    }

    public static StreamManagement.Enabled enabled(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, StreamManagement.Resume.ELEMENT, false);
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "location");
        int integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, "max", -1);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Enabled(attributeValue, booleanAttribute, attributeValue2, integerAttribute);
    }

    public static StreamManagement.Failed failed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ArrayList arrayList = new ArrayList(4);
        StanzaError.Condition condition = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(xmlPullParser.getNamespace())) {
                    if (name.equals("text")) {
                        arrayList.add(new StanzaErrorTextElement(xmlPullParser.nextText(), ParserUtils.getXmlLang(xmlPullParser)));
                    } else {
                        condition = StanzaError.Condition.fromString(name);
                    }
                }
            } else if (i10 == 2 && StreamManagement.Failed.ELEMENT.equals(xmlPullParser.getName())) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return new StreamManagement.Failed(condition, arrayList);
            }
        }
    }

    public static StreamManagement.Resumed resumed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long longValue = ParserUtils.getLongAttribute(xmlPullParser, "h").longValue();
        String attributeValue = xmlPullParser.getAttributeValue("", "previd");
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Resumed(longValue, attributeValue);
    }
}
