package org.jivesoftware.smackx.jingle_filetransfer.provider;

import java.io.IOException;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.hashes.provider.HashElementProvider;
import org.jivesoftware.smackx.jingle.provider.JingleContentDescriptionProvider;
import org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public class JingleFileTransferProvider extends JingleContentDescriptionProvider<JingleFileTransfer> {

    /* renamed from: org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                r1 = 1
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent[] r2 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = r2
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r3 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r2 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static Range parseRangeElement(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        Integer integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, Range.ATTR_OFFSET);
        Integer integerAttribute2 = ParserUtils.getIntegerAttribute(xmlPullParser, Range.ATTR_LENGTH);
        HashElement hashElement = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("hash")) {
                    hashElement = (HashElement) HashElementProvider.INSTANCE.parse(xmlPullParser);
                }
            } else if (i10 == 2 && xmlPullParser.getName().equals("range") && xmlPullParser.getDepth() == depth) {
                return new Range(integerAttribute, integerAttribute2, hashElement);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        if (r0.equals("hash") == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer parse(org.jivesoftware.smack.xml.XmlPullParser r6, int r7, org.jivesoftware.smack.packet.XmlEnvironment r8) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            r5 = this;
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild$Builder r8 = org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild.getBuilder()
        L_0x0009:
            org.jivesoftware.smack.xml.XmlPullParser$TagEvent r0 = r6.nextTag()
            int[] r1 = org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0046
            if (r0 == r1) goto L_0x001c
            goto L_0x0009
        L_0x001c:
            java.lang.String r0 = r6.getName()
            r0.hashCode()
            java.lang.String r1 = "description"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0034
            goto L_0x0009
        L_0x0034:
            org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild r8 = r8.build()
            r7.add(r8)
            org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild$Builder r8 = org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild.getBuilder()
            goto L_0x0009
        L_0x0040:
            org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer r6 = new org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer
            r6.<init>(r7)
            return r6
        L_0x0046:
            java.lang.String r0 = r6.getName()
            r0.hashCode()
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case 3076014: goto L_0x0097;
                case 3079825: goto L_0x008c;
                case 3195150: goto L_0x0083;
                case 3373707: goto L_0x0078;
                case 3530753: goto L_0x006d;
                case 108280125: goto L_0x0062;
                case 1893699459: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            r1 = r3
            goto L_0x00a1
        L_0x0057:
            java.lang.String r1 = "media-type"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0060
            goto L_0x0055
        L_0x0060:
            r1 = 6
            goto L_0x00a1
        L_0x0062:
            java.lang.String r1 = "range"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006b
            goto L_0x0055
        L_0x006b:
            r1 = 5
            goto L_0x00a1
        L_0x006d:
            java.lang.String r1 = "size"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0076
            goto L_0x0055
        L_0x0076:
            r1 = 4
            goto L_0x00a1
        L_0x0078:
            java.lang.String r1 = "name"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0081
            goto L_0x0055
        L_0x0081:
            r1 = 3
            goto L_0x00a1
        L_0x0083:
            java.lang.String r2 = "hash"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a1
            goto L_0x0055
        L_0x008c:
            java.lang.String r1 = "desc"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0095
            goto L_0x0055
        L_0x0095:
            r1 = r2
            goto L_0x00a1
        L_0x0097:
            java.lang.String r1 = "date"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a0
            goto L_0x0055
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            switch(r1) {
                case 0: goto L_0x00e4;
                case 1: goto L_0x00db;
                case 2: goto L_0x00ce;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00b8;
                case 5: goto L_0x00af;
                case 6: goto L_0x00a6;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            goto L_0x0009
        L_0x00a6:
            java.lang.String r0 = r6.nextText()
            r8.setMediaType(r0)
            goto L_0x0009
        L_0x00af:
            org.jivesoftware.smackx.jingle_filetransfer.element.Range r0 = parseRangeElement(r6)
            r8.setRange(r0)
            goto L_0x0009
        L_0x00b8:
            java.lang.String r0 = r6.nextText()
            int r0 = java.lang.Integer.parseInt(r0)
            r8.setSize(r0)
            goto L_0x0009
        L_0x00c5:
            java.lang.String r0 = r6.nextText()
            r8.setName(r0)
            goto L_0x0009
        L_0x00ce:
            org.jivesoftware.smackx.hashes.provider.HashElementProvider r0 = org.jivesoftware.smackx.hashes.provider.HashElementProvider.INSTANCE
            org.jivesoftware.smack.packet.Element r0 = r0.parse(r6)
            org.jivesoftware.smackx.hashes.element.HashElement r0 = (org.jivesoftware.smackx.hashes.element.HashElement) r0
            r8.setHash(r0)
            goto L_0x0009
        L_0x00db:
            java.lang.String r0 = r6.nextText()
            r8.setDescription(r0)
            goto L_0x0009
        L_0x00e4:
            java.lang.String r0 = r6.nextText()     // Catch:{ ParseException -> 0x00f1 }
            java.util.Date r0 = org.jxmpp.util.XmppDateTime.m(r0)     // Catch:{ ParseException -> 0x00f1 }
            r8.setDate(r0)     // Catch:{ ParseException -> 0x00f1 }
            goto L_0x0009
        L_0x00f1:
            r6 = move-exception
            org.jivesoftware.smack.parsing.SmackParsingException$SmackTextParseException r7 = new org.jivesoftware.smack.parsing.SmackParsingException$SmackTextParseException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer");
    }
}
