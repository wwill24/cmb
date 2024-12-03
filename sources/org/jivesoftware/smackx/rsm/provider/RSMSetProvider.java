package org.jivesoftware.smackx.rsm.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

public class RSMSetProvider extends ExtensionElementProvider<RSMSet> {
    public static final RSMSetProvider INSTANCE = new RSMSetProvider();

    /* renamed from: org.jivesoftware.smackx.rsm.provider.RSMSetProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.rsm.provider.RSMSetProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0.equals(org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk.ATTRIBUTE_LAST) == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.rsm.packet.RSMSet parse(org.jivesoftware.smack.xml.XmlPullParser r16, int r17, org.jivesoftware.smack.packet.XmlEnvironment r18) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r15 = this;
            r0 = 0
            r1 = -1
            r3 = r0
            r4 = r3
            r7 = r4
            r9 = r7
            r5 = r1
            r6 = r5
            r8 = r6
            r10 = r8
        L_0x000a:
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r16.next()
            int[] r2 = org.jivesoftware.smackx.rsm.provider.RSMSetProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 2
            r11 = 1
            if (r0 == r11) goto L_0x002f
            if (r0 == r2) goto L_0x0020
            r12 = r17
            goto L_0x008e
        L_0x0020:
            int r0 = r16.getDepth()
            r12 = r17
            if (r0 != r12) goto L_0x008e
            org.jivesoftware.smackx.rsm.packet.RSMSet r0 = new org.jivesoftware.smackx.rsm.packet.RSMSet
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x002f:
            r12 = r17
            java.lang.String r0 = r16.getName()
            r0.hashCode()
            int r13 = r0.hashCode()
            java.lang.String r14 = "index"
            switch(r13) {
                case -1392885889: goto L_0x0081;
                case 107876: goto L_0x0076;
                case 3314326: goto L_0x006d;
                case 92734940: goto L_0x0062;
                case 94851343: goto L_0x0057;
                case 97440432: goto L_0x004c;
                case 100346066: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r2 = r1
            goto L_0x008b
        L_0x0043:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x004a
            goto L_0x0041
        L_0x004a:
            r2 = 6
            goto L_0x008b
        L_0x004c:
            java.lang.String r2 = "first"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0055
            goto L_0x0041
        L_0x0055:
            r2 = 5
            goto L_0x008b
        L_0x0057:
            java.lang.String r2 = "count"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0060
            goto L_0x0041
        L_0x0060:
            r2 = 4
            goto L_0x008b
        L_0x0062:
            java.lang.String r2 = "after"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x006b
            goto L_0x0041
        L_0x006b:
            r2 = 3
            goto L_0x008b
        L_0x006d:
            java.lang.String r11 = "last"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x008b
            goto L_0x0041
        L_0x0076:
            java.lang.String r2 = "max"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x007f
            goto L_0x0041
        L_0x007f:
            r2 = r11
            goto L_0x008b
        L_0x0081:
            java.lang.String r2 = "before"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x008a
            goto L_0x0041
        L_0x008a:
            r2 = 0
        L_0x008b:
            switch(r2) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00bb;
                case 2: goto L_0x00b3;
                case 3: goto L_0x00ab;
                case 4: goto L_0x00a3;
                case 5: goto L_0x0097;
                case 6: goto L_0x0092;
                default: goto L_0x008e;
            }
        L_0x008e:
            r0 = r16
            goto L_0x000a
        L_0x0092:
            int r6 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto L_0x008e
        L_0x0097:
            r0 = r16
            int r10 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttribute(r0, r14, r1)
            java.lang.String r9 = r16.nextText()
            goto L_0x000a
        L_0x00a3:
            r0 = r16
            int r5 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto L_0x000a
        L_0x00ab:
            r0 = r16
            java.lang.String r3 = r16.nextText()
            goto L_0x000a
        L_0x00b3:
            r0 = r16
            java.lang.String r7 = r16.nextText()
            goto L_0x000a
        L_0x00bb:
            r0 = r16
            int r8 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto L_0x000a
        L_0x00c3:
            r0 = r16
            java.lang.String r4 = r16.nextText()
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.rsm.provider.RSMSetProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.rsm.packet.RSMSet");
    }
}
