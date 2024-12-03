package org.jivesoftware.smack.compress.provider;

import java.util.logging.Logger;
import org.jivesoftware.smack.compress.packet.Failure;
import org.jivesoftware.smack.provider.NonzaProvider;

public final class FailureProvider extends NonzaProvider<Failure> {
    public static final FailureProvider INSTANCE = new FailureProvider();
    private static final Logger LOGGER = Logger.getLogger(FailureProvider.class.getName());

    /* renamed from: org.jivesoftware.smack.compress.provider.FailureProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.compress.provider.FailureProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private FailureProvider() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        if (r5.equals("http://jabber.org/protocol/compress") == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smack.compress.packet.Failure parse(org.jivesoftware.smack.xml.XmlPullParser r9, int r10, org.jivesoftware.smack.packet.XmlEnvironment r11) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            r8 = this;
            org.jivesoftware.smack.packet.XmlEnvironment r11 = org.jivesoftware.smack.packet.XmlEnvironment.from(r9, r11)
            r0 = 0
            r1 = r0
        L_0x0006:
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r9.next()
            int[] r3 = org.jivesoftware.smack.compress.provider.FailureProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0025
            if (r2 == r3) goto L_0x0019
            goto L_0x0006
        L_0x0019:
            int r2 = r9.getDepth()
            if (r2 != r10) goto L_0x0006
            org.jivesoftware.smack.compress.packet.Failure r9 = new org.jivesoftware.smack.compress.packet.Failure
            r9.<init>(r0, r1)
            return r9
        L_0x0025:
            java.lang.String r2 = r9.getName()
            java.lang.String r5 = r9.getNamespace()
            r5.hashCode()
            r6 = -1
            int r7 = r5.hashCode()
            switch(r7) {
                case -1665385119: goto L_0x004e;
                case -1213499175: goto L_0x0043;
                case 2117926358: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r3 = r6
            goto L_0x0058
        L_0x003a:
            java.lang.String r4 = "http://jabber.org/protocol/compress"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0058
            goto L_0x0038
        L_0x0043:
            java.lang.String r3 = "jabber:server"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x004c
            goto L_0x0038
        L_0x004c:
            r3 = r4
            goto L_0x0058
        L_0x004e:
            java.lang.String r3 = "jabber:client"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x0057
            goto L_0x0038
        L_0x0057:
            r3 = 0
        L_0x0058:
            switch(r3) {
                case 0: goto L_0x0081;
                case 1: goto L_0x0081;
                case 2: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0006
        L_0x005c:
            java.lang.String r0 = "-"
            java.lang.String r3 = "_"
            java.lang.String r0 = r2.replace(r0, r3)
            org.jivesoftware.smack.compress.packet.Failure$CompressFailureError r0 = org.jivesoftware.smack.compress.packet.Failure.CompressFailureError.valueOf(r0)
            if (r0 != 0) goto L_0x0006
            java.util.logging.Logger r3 = LOGGER
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown element in http://jabber.org/protocol/compress: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.warning(r2)
            goto L_0x0006
        L_0x0081:
            r2.hashCode()
            java.lang.String r3 = "error"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00ac
            java.util.logging.Logger r3 = LOGGER
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Unknown element in "
            r4.append(r6)
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.warning(r2)
            goto L_0x0006
        L_0x00ac:
            org.jivesoftware.smack.packet.StanzaError r1 = org.jivesoftware.smack.util.PacketParserUtils.parseError(r9, r11)
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.compress.provider.FailureProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smack.compress.packet.Failure");
    }
}
