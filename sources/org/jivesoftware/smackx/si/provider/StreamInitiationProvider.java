package org.jivesoftware.smackx.si.provider;

import java.util.logging.Logger;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.si.packet.StreamInitiation;

public class StreamInitiationProvider extends IQProvider<StreamInitiation> {
    private static final Logger LOGGER = Logger.getLogger(StreamInitiationProvider.class.getName());

    /* JADX WARNING: type inference failed for: r0v18, types: [org.jivesoftware.smack.packet.Element] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f2 A[SYNTHETIC, Splitter:B:39:0x00f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.si.packet.StreamInitiation parse(org.jivesoftware.smack.xml.XmlPullParser r19, int r20, org.jivesoftware.smack.packet.XmlEnvironment r21) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            r18 = this;
            r1 = r19
            java.lang.String r2 = ""
            java.lang.String r0 = "id"
            java.lang.String r3 = r1.getAttributeValue(r2, r0)
            java.lang.String r0 = "mime-type"
            java.lang.String r4 = r1.getAttributeValue(r2, r0)
            org.jivesoftware.smackx.si.packet.StreamInitiation r5 = new org.jivesoftware.smackx.si.packet.StreamInitiation
            r5.<init>()
            org.jivesoftware.smackx.xdata.provider.DataFormProvider r6 = new org.jivesoftware.smackx.xdata.provider.DataFormProvider
            r6.<init>()
            r0 = 0
            r7 = 0
            r8 = r0
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r7
            r7 = r12
        L_0x0023:
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r19.next()
            org.jivesoftware.smack.xml.XmlPullParser$Event r14 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            java.lang.String r15 = "file"
            if (r0 != r14) goto L_0x008c
            java.lang.String r0 = r19.getName()
            java.lang.String r14 = r19.getNamespace()
            boolean r15 = r0.equals(r15)
            if (r15 == 0) goto L_0x0054
            java.lang.String r0 = "name"
            java.lang.String r9 = r1.getAttributeValue(r2, r0)
            java.lang.String r0 = "size"
            java.lang.String r7 = r1.getAttributeValue(r2, r0)
            java.lang.String r0 = "hash"
            java.lang.String r10 = r1.getAttributeValue(r2, r0)
            java.lang.String r0 = "date"
            java.lang.String r11 = r1.getAttributeValue(r2, r0)
            goto L_0x0082
        L_0x0054:
            java.lang.String r15 = "desc"
            boolean r15 = r0.equals(r15)
            if (r15 == 0) goto L_0x0061
            java.lang.String r12 = r19.nextText()
            goto L_0x0082
        L_0x0061:
            java.lang.String r15 = "range"
            boolean r15 = r0.equals(r15)
            if (r15 == 0) goto L_0x006b
            r13 = 1
            goto L_0x0082
        L_0x006b:
            java.lang.String r15 = "x"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0082
            java.lang.String r0 = "jabber:x:data"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x0082
            org.jivesoftware.smack.packet.Element r0 = r6.parse(r1)
            r8 = r0
            org.jivesoftware.smackx.xdata.packet.DataForm r8 = (org.jivesoftware.smackx.xdata.packet.DataForm) r8
        L_0x0082:
            r14 = r20
            r21 = r2
        L_0x0086:
            r16 = r3
            r17 = r4
            goto L_0x010a
        L_0x008c:
            org.jivesoftware.smack.xml.XmlPullParser$Event r14 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT
            if (r0 != r14) goto L_0x0082
            int r0 = r19.getDepth()
            r14 = r20
            if (r0 != r14) goto L_0x00a2
            r5.setSessionID(r3)
            r5.setMimeType(r4)
            r5.setFeatureNegotiationForm(r8)
            return r5
        L_0x00a2:
            java.lang.String r0 = r19.getName()
            boolean r0 = r0.equals(r15)
            r21 = r2
            if (r0 == 0) goto L_0x0086
            if (r7 == 0) goto L_0x00e4
            java.lang.String r0 = r7.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x00e4
            long r1 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x00c3 }
            r16 = r3
            r17 = r4
            goto L_0x00eb
        L_0x00c3:
            r0 = move-exception
            r15 = r0
            java.util.logging.Logger r0 = LOGGER
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r16 = r3
            java.lang.String r3 = "Failed to parse file size from "
            r2.append(r3)
            r17 = r4
            r3 = 0
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.log(r1, r2, r15)
            goto L_0x00ea
        L_0x00e4:
            r16 = r3
            r17 = r4
            r3 = 0
        L_0x00ea:
            r1 = r3
        L_0x00eb:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            if (r11 == 0) goto L_0x00f6
            java.util.Date r0 = org.jxmpp.util.XmppDateTime.l(r11)     // Catch:{ ParseException -> 0x00f6 }
        L_0x00f6:
            org.jivesoftware.smackx.si.packet.StreamInitiation$File r3 = new org.jivesoftware.smackx.si.packet.StreamInitiation$File
            r3.<init>(r9, r1)
            r3.setHash(r10)
            r3.setDate(r0)
            r3.setDesc(r12)
            r3.setRanged(r13)
            r5.setFile(r3)
        L_0x010a:
            r1 = r19
            r2 = r21
            r3 = r16
            r4 = r17
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.si.provider.StreamInitiationProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.si.packet.StreamInitiation");
    }
}
