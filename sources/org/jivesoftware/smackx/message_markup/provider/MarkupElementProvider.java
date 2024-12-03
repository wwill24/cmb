package org.jivesoftware.smackx.message_markup.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

public class MarkupElementProvider extends ExtensionElementProvider<MarkupElement> {

    /* renamed from: org.jivesoftware.smackx.message_markup.provider.MarkupElementProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.message_markup.provider.MarkupElementProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f0, code lost:
        if (r9.equals("code") == false) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.message_markup.element.MarkupElement parse(org.jivesoftware.smack.xml.XmlPullParser r18, int r19, org.jivesoftware.smack.packet.XmlEnvironment r20) throws java.io.IOException, org.jivesoftware.smack.xml.XmlPullParserException {
        /*
            r17 = this;
            r0 = r18
            org.jivesoftware.smackx.message_markup.element.MarkupElement$Builder r1 = org.jivesoftware.smackx.message_markup.element.MarkupElement.getBuilder()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -1
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L_0x0015:
            org.jivesoftware.smack.xml.XmlPullParser$Event r9 = r18.next()
            int[] r10 = org.jivesoftware.smackx.message_markup.provider.MarkupElementProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r9 = r9.ordinal()
            r9 = r10[r9]
            java.lang.String r10 = "span"
            java.lang.String r11 = "list"
            r12 = 2
            r13 = 0
            r14 = 1
            if (r9 == r14) goto L_0x00a5
            if (r9 == r12) goto L_0x002f
            r15 = r19
            goto L_0x0015
        L_0x002f:
            int r9 = r18.getDepth()
            r15 = r19
            if (r9 != r15) goto L_0x003c
            org.jivesoftware.smackx.message_markup.element.MarkupElement r0 = r1.build()
            return r0
        L_0x003c:
            java.lang.String r9 = r18.getName()
            r9.hashCode()
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x0056
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0050
            goto L_0x0015
        L_0x0050:
            r1.addSpan(r5, r6, r2)
            r5 = r4
            r6 = r5
            goto L_0x0015
        L_0x0056:
            org.jivesoftware.smackx.message_markup.element.MarkupElement$Builder$ListBuilder r9 = r1.beginList()
            int r10 = r3.size()
            if (r10 <= 0) goto L_0x0075
            java.lang.Object r10 = r3.get(r13)
            org.jivesoftware.smackx.message_markup.element.ListElement$ListEntryElement r10 = (org.jivesoftware.smackx.message_markup.element.ListElement.ListEntryElement) r10
            int r10 = r10.getStart()
            if (r10 != r7) goto L_0x006d
            goto L_0x0075
        L_0x006d:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Error while parsing incoming MessageMarkup ListElement: 'start' attribute of first 'li' element must equal 'start' attribute of list."
            r0.<init>(r1)
            throw r0
        L_0x0075:
            int r10 = r3.size()
            if (r13 >= r10) goto L_0x00a0
            java.lang.Object r10 = r3.get(r13)
            org.jivesoftware.smackx.message_markup.element.ListElement$ListEntryElement r10 = (org.jivesoftware.smackx.message_markup.element.ListElement.ListEntryElement) r10
            int r10 = r10.getStart()
            int r11 = r3.size()
            int r11 = r11 - r14
            if (r13 >= r11) goto L_0x0099
            int r11 = r13 + 1
            java.lang.Object r11 = r3.get(r11)
            org.jivesoftware.smackx.message_markup.element.ListElement$ListEntryElement r11 = (org.jivesoftware.smackx.message_markup.element.ListElement.ListEntryElement) r11
            int r11 = r11.getStart()
            goto L_0x009a
        L_0x0099:
            r11 = r8
        L_0x009a:
            r9.addEntry(r10, r11)
            int r13 = r13 + 1
            goto L_0x0075
        L_0x00a0:
            r9.endList()
            goto L_0x0015
        L_0x00a5:
            r15 = r19
            java.lang.String r9 = r18.getName()
            r9.hashCode()
            int r16 = r9.hashCode()
            switch(r16) {
                case -1381356710: goto L_0x00fe;
                case 3453: goto L_0x00f3;
                case 3059181: goto L_0x00ea;
                case 3322014: goto L_0x00e1;
                case 3536714: goto L_0x00d8;
                case 93564239: goto L_0x00cd;
                case 1189352828: goto L_0x00c2;
                case 1550463001: goto L_0x00b7;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            r12 = r4
            goto L_0x0108
        L_0x00b7:
            java.lang.String r10 = "deleted"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00c0
            goto L_0x00b5
        L_0x00c0:
            r12 = 7
            goto L_0x0108
        L_0x00c2:
            java.lang.String r10 = "emphasis"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00cb
            goto L_0x00b5
        L_0x00cb:
            r12 = 6
            goto L_0x0108
        L_0x00cd:
            java.lang.String r10 = "bcode"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00d6
            goto L_0x00b5
        L_0x00d6:
            r12 = 5
            goto L_0x0108
        L_0x00d8:
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00df
            goto L_0x00b5
        L_0x00df:
            r12 = 4
            goto L_0x0108
        L_0x00e1:
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x00e8
            goto L_0x00b5
        L_0x00e8:
            r12 = 3
            goto L_0x0108
        L_0x00ea:
            java.lang.String r10 = "code"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0108
            goto L_0x00b5
        L_0x00f3:
            java.lang.String r10 = "li"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00fc
            goto L_0x00b5
        L_0x00fc:
            r12 = r14
            goto L_0x0108
        L_0x00fe:
            java.lang.String r10 = "bquote"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0107
            goto L_0x00b5
        L_0x0107:
            r12 = r13
        L_0x0108:
            java.lang.String r9 = "end"
            java.lang.String r10 = "start"
            switch(r12) {
                case 0: goto L_0x016d;
                case 1: goto L_0x015d;
                case 2: goto L_0x0156;
                case 3: goto L_0x0143;
                case 4: goto L_0x0130;
                case 5: goto L_0x011f;
                case 6: goto L_0x0118;
                case 7: goto L_0x0111;
                default: goto L_0x010f;
            }
        L_0x010f:
            goto L_0x0015
        L_0x0111:
            org.jivesoftware.smackx.message_markup.element.SpanElement$SpanStyle r9 = org.jivesoftware.smackx.message_markup.element.SpanElement.SpanStyle.deleted
            r2.add(r9)
            goto L_0x0015
        L_0x0118:
            org.jivesoftware.smackx.message_markup.element.SpanElement$SpanStyle r9 = org.jivesoftware.smackx.message_markup.element.SpanElement.SpanStyle.emphasis
            r2.add(r9)
            goto L_0x0015
        L_0x011f:
            java.lang.String r11 = "Message Markup CodeBlockElement MUST contain a 'start' attribute."
            int r10 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r10, r11)
            java.lang.String r11 = "Message Markup CodeBlockElement MUST contain a 'end' attribute."
            int r9 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r9, r11)
            r1.setCodeBlock(r10, r9)
            goto L_0x0015
        L_0x0130:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.lang.String r5 = "Message Markup SpanElement MUST contain a 'start' attribute."
            int r5 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r10, r5)
            java.lang.String r6 = "Message Markup SpanElement MUST contain a 'end' attribute."
            int r6 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r9, r6)
            goto L_0x0015
        L_0x0143:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r7 = "Message Markup ListElement MUST contain a 'start' attribute."
            int r7 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r10, r7)
            java.lang.String r8 = "Message Markup ListElement MUST contain a 'end' attribute."
            int r8 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r9, r8)
            goto L_0x0015
        L_0x0156:
            org.jivesoftware.smackx.message_markup.element.SpanElement$SpanStyle r9 = org.jivesoftware.smackx.message_markup.element.SpanElement.SpanStyle.code
            r2.add(r9)
            goto L_0x0015
        L_0x015d:
            java.lang.String r9 = "Message Markup ListElement 'li' MUST contain a 'start' attribute."
            int r9 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r10, r9)
            org.jivesoftware.smackx.message_markup.element.ListElement$ListEntryElement r10 = new org.jivesoftware.smackx.message_markup.element.ListElement$ListEntryElement
            r10.<init>(r9)
            r3.add(r10)
            goto L_0x0015
        L_0x016d:
            java.lang.String r11 = "Message Markup BlockQuoteElement MUST contain a 'start' attribute."
            int r10 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r10, r11)
            java.lang.String r11 = "Message Markup BlockQuoteElement MUST contain a 'end' attribute."
            int r9 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttributeOrThrow(r0, r9, r11)
            r1.setBlockQuote(r10, r9)
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.message_markup.provider.MarkupElementProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.message_markup.element.MarkupElement");
    }
}
