package org.jivesoftware.smackx.xdatalayout.provider;

import java.io.IOException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

public class DataLayoutProvider {

    /* renamed from: org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static DataLayout parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        DataLayout dataLayout = new DataLayout(xmlPullParser.getAttributeValue("", "label"));
        parseLayout(dataLayout.getPageLayout(), xmlPullParser);
        return dataLayout;
    }

    private static DataLayout.Fieldref parseFieldref(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        DataLayout.Fieldref fieldref = new DataLayout.Fieldref(xmlPullParser.getAttributeValue("", "var"));
        while (true) {
            if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return fieldref;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (r1.equals("text") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseLayout(java.util.List<org.jivesoftware.smackx.xdatalayout.packet.DataLayout.DataFormLayoutElement> r6, org.jivesoftware.smack.xml.XmlPullParser r7) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r7.getDepth()
        L_0x0004:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r7.next()
            int[] r2 = org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x001e
            if (r1 == r2) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            int r1 = r7.getDepth()
            if (r1 != r0) goto L_0x0004
            return
        L_0x001e:
            java.lang.String r1 = r7.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -928989863: goto L_0x004e;
                case -241484064: goto L_0x0043;
                case 3556653: goto L_0x003a;
                case 1970241253: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = r4
            goto L_0x0058
        L_0x002f:
            java.lang.String r2 = "section"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 3
            goto L_0x0058
        L_0x003a:
            java.lang.String r3 = "text"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0058
            goto L_0x002d
        L_0x0043:
            java.lang.String r2 = "reportedref"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            r2 = r3
            goto L_0x0058
        L_0x004e:
            java.lang.String r2 = "fieldref"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            r2 = 0
        L_0x0058:
            switch(r2) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0071;
                case 2: goto L_0x0064;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0004
        L_0x005c:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Section r1 = parseSection(r7)
            r6.add(r1)
            goto L_0x0004
        L_0x0064:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Text r1 = new org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Text
            java.lang.String r2 = r7.nextText()
            r1.<init>(r2)
            r6.add(r1)
            goto L_0x0004
        L_0x0071:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Reportedref r1 = new org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Reportedref
            r1.<init>()
            r6.add(r1)
            goto L_0x0004
        L_0x007a:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Fieldref r1 = parseFieldref(r7)
            r6.add(r1)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.parseLayout(java.util.List, org.jivesoftware.smack.xml.XmlPullParser):void");
    }

    private static DataLayout.Section parseSection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        DataLayout.Section section = new DataLayout.Section(xmlPullParser.getAttributeValue("", "label"));
        parseLayout(section.getSectionLayout(), xmlPullParser);
        return section;
    }
}
