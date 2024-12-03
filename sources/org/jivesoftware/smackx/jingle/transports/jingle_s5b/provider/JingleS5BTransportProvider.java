package org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider;

import org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;

public class JingleS5BTransportProvider extends JingleContentTransportProvider<JingleS5BTransport> {

    /* renamed from: org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent[] r0 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = r0
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r1 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r1 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007c, code lost:
        if (r1.equals(org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo.ProxyError.ELEMENT) == false) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport parse(org.jivesoftware.smack.xml.XmlPullParser r7, int r8, org.jivesoftware.smack.packet.XmlEnvironment r9) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport$Builder r9 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport.getBuilder()
            r0 = 0
            java.lang.String r1 = "sid"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r9.setStreamId(r1)
            java.lang.String r1 = "dstaddr"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r9.setDestinationAddress(r1)
            java.lang.String r1 = "mode"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            if (r1 == 0) goto L_0x0031
            org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream$Mode r2 = org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.Mode.udp
            java.lang.String r3 = r2.toString()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream$Mode r2 = org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.Mode.tcp
        L_0x002e:
            r9.setMode(r2)
        L_0x0031:
            org.jivesoftware.smack.xml.XmlPullParser$TagEvent r1 = r7.nextTag()
            int[] r2 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x004f
            if (r1 == r2) goto L_0x0044
            goto L_0x0031
        L_0x0044:
            int r1 = r7.getDepth()
            if (r1 != r8) goto L_0x0031
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport r7 = r9.build()
            return r7
        L_0x004f:
            java.lang.String r1 = r7.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1033040578: goto L_0x008a;
                case 508663171: goto L_0x007f;
                case 995927529: goto L_0x0076;
                case 1352626631: goto L_0x006b;
                case 2000321031: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            r2 = r4
            goto L_0x0094
        L_0x0060:
            java.lang.String r2 = "candidate-activated"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0069
            goto L_0x005e
        L_0x0069:
            r2 = 4
            goto L_0x0094
        L_0x006b:
            java.lang.String r2 = "candidate-used"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0074
            goto L_0x005e
        L_0x0074:
            r2 = 3
            goto L_0x0094
        L_0x0076:
            java.lang.String r3 = "proxy-error"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0094
            goto L_0x005e
        L_0x007f:
            java.lang.String r2 = "candidate"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0088
            goto L_0x005e
        L_0x0088:
            r2 = r3
            goto L_0x0094
        L_0x008a:
            java.lang.String r2 = "candidate-error"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0093
            goto L_0x005e
        L_0x0093:
            r2 = 0
        L_0x0094:
            java.lang.String r1 = "cid"
            switch(r2) {
                case 0: goto L_0x010d;
                case 1: goto L_0x00bc;
                case 2: goto L_0x00b5;
                case 3: goto L_0x00a7;
                case 4: goto L_0x009a;
                default: goto L_0x0099;
            }
        L_0x0099:
            goto L_0x0031
        L_0x009a:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$CandidateActivated r2 = new org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$CandidateActivated
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r2.<init>(r1)
            r9.setTransportInfo(r2)
            goto L_0x0031
        L_0x00a7:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$CandidateUsed r2 = new org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$CandidateUsed
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r2.<init>(r1)
            r9.setTransportInfo(r2)
            goto L_0x0031
        L_0x00b5:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$ProxyError r1 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo.ProxyError.INSTANCE
            r9.setTransportInfo(r1)
            goto L_0x0031
        L_0x00bc:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate$Builder r2 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate.getBuilder()
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r2.setCandidateId(r1)
            java.lang.String r1 = "host"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r2.setHost((java.lang.String) r1)
            java.lang.String r1 = "jid"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            r2.setJid(r1)
            java.lang.String r1 = "priority"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            int r1 = java.lang.Integer.parseInt(r1)
            r2.setPriority(r1)
            java.lang.String r1 = "port"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            if (r1 == 0) goto L_0x00f5
            int r1 = java.lang.Integer.parseInt(r1)
            r2.setPort(r1)
        L_0x00f5:
            java.lang.String r1 = "type"
            java.lang.String r1 = r7.getAttributeValue(r0, r1)
            if (r1 == 0) goto L_0x0104
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate$Type r1 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate.Type.fromString(r1)
            r2.setType(r1)
        L_0x0104:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate r1 = r2.build()
            r9.addTransportCandidate(r1)
            goto L_0x0031
        L_0x010d:
            org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo$CandidateError r1 = org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo.CandidateError.INSTANCE
            r9.setTransportInfo(r1)
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport");
    }
}
