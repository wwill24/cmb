package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityJid;

public class MUCUserProvider extends ExtensionElementProvider<MUCUser> {

    /* renamed from: org.jivesoftware.smackx.muc.provider.MUCUserProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.provider.MUCUserProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private static MUCUser.Decline parseDecline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser, "to");
        EntityBareJid bareJidAttribute2 = ParserUtils.getBareJidAttribute(xmlPullParser, "from");
        String str = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(JingleReason.ELEMENT)) {
                    str = xmlPullParser.nextText();
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(MUCUser.Decline.ELEMENT)) {
                return new MUCUser.Decline(str, bareJidAttribute2, bareJidAttribute);
            }
        }
    }

    private static MUCUser.Invite parseInvite(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser, "to");
        EntityJid entityJidAttribute = ParserUtils.getEntityJidAttribute(xmlPullParser, "from");
        String str = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals(JingleReason.ELEMENT)) {
                    str = xmlPullParser.nextText();
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(MUCUser.Invite.ELEMENT)) {
                return new MUCUser.Invite(str, entityJidAttribute, bareJidAttribute);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r0.equals("item") == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.muc.packet.MUCUser parse(org.jivesoftware.smack.xml.XmlPullParser r6, int r7, org.jivesoftware.smack.packet.XmlEnvironment r8) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            org.jivesoftware.smackx.muc.packet.MUCUser r8 = new org.jivesoftware.smackx.muc.packet.MUCUser
            r8.<init>()
        L_0x0005:
            int[] r0 = org.jivesoftware.smackx.muc.provider.MUCUserProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r6.next()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x001f
            if (r0 == r1) goto L_0x0018
            goto L_0x0005
        L_0x0018:
            int r0 = r6.getDepth()
            if (r0 != r7) goto L_0x0005
            return r8
        L_0x001f:
            java.lang.String r0 = r6.getName()
            r0.hashCode()
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1183699191: goto L_0x0065;
                case -892481550: goto L_0x005a;
                case 3242771: goto L_0x0051;
                case 1216985755: goto L_0x0046;
                case 1542349558: goto L_0x003b;
                case 1557372922: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            r1 = r3
            goto L_0x006f
        L_0x0030:
            java.lang.String r1 = "destroy"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r1 = 5
            goto L_0x006f
        L_0x003b:
            java.lang.String r1 = "decline"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            r1 = 4
            goto L_0x006f
        L_0x0046:
            java.lang.String r1 = "password"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004f
            goto L_0x002e
        L_0x004f:
            r1 = 3
            goto L_0x006f
        L_0x0051:
            java.lang.String r2 = "item"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x006f
            goto L_0x002e
        L_0x005a:
            java.lang.String r1 = "status"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0063
            goto L_0x002e
        L_0x0063:
            r1 = r2
            goto L_0x006f
        L_0x0065:
            java.lang.String r1 = "invite"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006e
            goto L_0x002e
        L_0x006e:
            r1 = 0
        L_0x006f:
            switch(r1) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x0095;
                case 2: goto L_0x008c;
                case 3: goto L_0x0083;
                case 4: goto L_0x007b;
                case 5: goto L_0x0073;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x0005
        L_0x0073:
            org.jivesoftware.smackx.muc.packet.Destroy r0 = org.jivesoftware.smackx.muc.provider.MUCParserUtils.parseDestroy(r6)
            r8.setDestroy(r0)
            goto L_0x0005
        L_0x007b:
            org.jivesoftware.smackx.muc.packet.MUCUser$Decline r0 = parseDecline(r6)
            r8.setDecline(r0)
            goto L_0x0005
        L_0x0083:
            java.lang.String r0 = r6.nextText()
            r8.setPassword(r0)
            goto L_0x0005
        L_0x008c:
            org.jivesoftware.smackx.muc.packet.MUCItem r0 = org.jivesoftware.smackx.muc.provider.MUCParserUtils.parseItem(r6)
            r8.setItem(r0)
            goto L_0x0005
        L_0x0095:
            java.lang.String r0 = ""
            java.lang.String r1 = "code"
            java.lang.String r0 = r6.getAttributeValue(r0, r1)
            org.jivesoftware.smackx.muc.packet.MUCUser$Status r0 = org.jivesoftware.smackx.muc.packet.MUCUser.Status.create((java.lang.String) r0)
            r8.addStatusCode(r0)
            goto L_0x0005
        L_0x00a6:
            org.jivesoftware.smackx.muc.packet.MUCUser$Invite r0 = parseInvite(r6)
            r8.setInvite(r0)
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.provider.MUCUserProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.muc.packet.MUCUser");
    }
}
