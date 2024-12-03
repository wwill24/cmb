package org.jivesoftware.smack.roster.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.impl.a;

public class RosterPacketProvider extends IQProvider<RosterPacket> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final RosterPacketProvider INSTANCE = new RosterPacketProvider();

    /* renamed from: org.jivesoftware.smack.roster.provider.RosterPacketProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.roster.provider.RosterPacketProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static RosterPacket.Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String nextText;
        ParserUtils.assertAtStartTag(xmlPullParser, "item");
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("", "jid");
        RosterPacket.Item item = new RosterPacket.Item(a.b(attributeValue), xmlPullParser.getAttributeValue("", "name"));
        item.setSubscriptionPending("subscribe".equals(xmlPullParser.getAttributeValue("", "ask")));
        item.setItemType(RosterPacket.ItemType.fromString(xmlPullParser.getAttributeValue("", "subscription")));
        item.setApproved(ParserUtils.getBooleanAttribute(xmlPullParser, "approved", false));
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("group") && (nextText = xmlPullParser.nextText()) != null && nextText.trim().length() > 0) {
                    item.addGroupName(nextText);
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return item;
            }
        }
    }

    public RosterPacket parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setVersion(xmlPullParser.getAttributeValue("", RosterVer.ELEMENT));
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("item")) {
                    rosterPacket.addRosterItem(parseItem(xmlPullParser));
                }
            } else if (i11 != 2) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals("query") && xmlPullParser.getDepth() == i10) {
                    return rosterPacket;
                }
            }
        }
    }
}
