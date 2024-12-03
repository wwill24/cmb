package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public class MUCParserUtils {

    /* renamed from: org.jivesoftware.smackx.muc.provider.MUCParserUtils$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.provider.MUCParserUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static Destroy parseDestroy(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser);
        String str = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(JingleReason.ELEMENT)) {
                    str = xmlPullParser.nextText();
                }
            } else if (i10 == 2 && depth == xmlPullParser.getDepth()) {
                return new Destroy(bareJidAttribute, str);
            }
        }
    }

    public static MUCItem parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        MUCAffiliation fromString = MUCAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation"));
        Resourcepart resourcepartAttribute = ParserUtils.getResourcepartAttribute(xmlPullParser, "nick");
        MUCRole fromString2 = MUCRole.fromString(xmlPullParser.getAttributeValue("", "role"));
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        Jid jid = null;
        String str = null;
        Resourcepart resourcepart = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(JingleReason.ELEMENT)) {
                    str = xmlPullParser.nextText();
                } else if (name.equals("actor")) {
                    Jid jidAttribute2 = ParserUtils.getJidAttribute(xmlPullParser);
                    String attributeValue = xmlPullParser.getAttributeValue("", "nick");
                    if (attributeValue != null) {
                        resourcepart = Resourcepart.b(attributeValue);
                    }
                    jid = jidAttribute2;
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new MUCItem(fromString, fromString2, jid, str, jidAttribute, resourcepartAttribute, resourcepart);
            }
        }
    }
}
