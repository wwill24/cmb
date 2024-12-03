package org.jivesoftware.smackx.privacy.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

public class PrivacyProvider extends IQProvider<Privacy> {

    /* renamed from: org.jivesoftware.smackx.privacy.provider.PrivacyProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.privacy.provider.PrivacyProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private static PrivacyItem parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z10;
        PrivacyItem privacyItem;
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        UInt32 uInt32Attribute = ParserUtils.getUInt32Attribute(xmlPullParser, "order");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "type");
        attributeValue.hashCode();
        if (attributeValue.equals("deny")) {
            z10 = false;
        } else if (attributeValue.equals("allow")) {
            z10 = true;
        } else {
            throw new IOException("Unknown action value '" + attributeValue + "'");
        }
        if (attributeValue2 != null) {
            privacyItem = new PrivacyItem(PrivacyItem.Type.valueOf(attributeValue2), xmlPullParser.getAttributeValue("", "value"), z10, uInt32Attribute);
        } else {
            privacyItem = new PrivacyItem(z10, uInt32Attribute);
        }
        parseItemChildElements(xmlPullParser, privacyItem);
        return privacyItem;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (r1.equals("presence-out") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseItemChildElements(org.jivesoftware.smack.xml.XmlPullParser r6, org.jivesoftware.smackx.privacy.packet.PrivacyItem r7) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r6.getDepth()
        L_0x0004:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r6.next()
            int[] r2 = org.jivesoftware.smackx.privacy.provider.PrivacyProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x001e
            if (r1 == r2) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            int r1 = r6.getDepth()
            if (r1 != r0) goto L_0x0004
            return
        L_0x001e:
            java.lang.String r1 = r6.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1240091849: goto L_0x004e;
                case 3368: goto L_0x0043;
                case 211864444: goto L_0x003a;
                case 954925063: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = r4
            goto L_0x0058
        L_0x002f:
            java.lang.String r2 = "message"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 3
            goto L_0x0058
        L_0x003a:
            java.lang.String r5 = "presence-out"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0058
            goto L_0x002d
        L_0x0043:
            java.lang.String r2 = "iq"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            r2 = r3
            goto L_0x0058
        L_0x004e:
            java.lang.String r2 = "presence-in"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            r2 = 0
        L_0x0058:
            switch(r2) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0064;
                case 2: goto L_0x0060;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0004
        L_0x005c:
            r7.setFilterMessage(r3)
            goto L_0x0004
        L_0x0060:
            r7.setFilterPresenceOut(r3)
            goto L_0x0004
        L_0x0064:
            r7.setFilterIQ(r3)
            goto L_0x0004
        L_0x0068:
            r7.setFilterPresenceIn(r3)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.privacy.provider.PrivacyProvider.parseItemChildElements(org.jivesoftware.smack.xml.XmlPullParser, org.jivesoftware.smackx.privacy.packet.PrivacyItem):void");
    }

    private static void parseList(XmlPullParser xmlPullParser, Privacy privacy) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("item")) {
                    arrayList.add(parseItem(xmlPullParser));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("list")) {
                z10 = true;
            }
        }
        privacy.setPrivacyList(attributeValue, arrayList);
    }

    public Privacy parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Privacy privacy = new Privacy();
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(ClientStateIndication.Active.ELEMENT)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue == null) {
                        privacy.setDeclineActiveList(true);
                    } else {
                        privacy.setActiveName(attributeValue);
                    }
                } else if (xmlPullParser.getName().equals("default")) {
                    String attributeValue2 = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue2 == null) {
                        privacy.setDeclineDefaultList(true);
                    } else {
                        privacy.setDefaultName(attributeValue2);
                    }
                } else if (xmlPullParser.getName().equals("list")) {
                    parseList(xmlPullParser, privacy);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                z10 = true;
            }
        }
        return privacy;
    }
}
