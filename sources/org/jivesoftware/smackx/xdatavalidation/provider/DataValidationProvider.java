package org.jivesoftware.smackx.xdatavalidation.provider;

import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;

public class DataValidationProvider extends FormFieldChildElementProvider<ValidateElement> {
    private static final Logger LOGGER = Logger.getLogger(DataValidationProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public QName getQName() {
        return ValidateElement.QNAME;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r3.equals(org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.BasicValidateElement.METHOD) == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement parse(org.jivesoftware.smack.xml.XmlPullParser r9, int r10, org.jivesoftware.smack.packet.XmlEnvironment r11) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            java.lang.String r11 = ""
            java.lang.String r0 = "datatype"
            java.lang.String r0 = r9.getAttributeValue(r11, r0)
            r1 = 0
            r2 = r1
        L_0x000a:
            org.jivesoftware.smack.xml.XmlPullParser$Event r3 = r9.next()
            int[] r4 = org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 2
            r5 = 1
            if (r3 == r5) goto L_0x002e
            if (r3 == r4) goto L_0x001d
            goto L_0x000a
        L_0x001d:
            int r3 = r9.getDepth()
            if (r3 != r10) goto L_0x000a
            if (r1 != 0) goto L_0x002a
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement r1 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement
            r1.<init>(r0)
        L_0x002a:
            r1.setListRange(r2)
            return r1
        L_0x002e:
            java.lang.String r3 = r9.getName()
            r3.hashCode()
            r6 = -1
            int r7 = r3.hashCode()
            switch(r7) {
                case -725250226: goto L_0x0069;
                case 3417674: goto L_0x005e;
                case 93508654: goto L_0x0055;
                case 108280125: goto L_0x004a;
                case 108392519: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            r4 = r6
            goto L_0x0073
        L_0x003f:
            java.lang.String r4 = "regex"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0048
            goto L_0x003d
        L_0x0048:
            r4 = 4
            goto L_0x0073
        L_0x004a:
            java.lang.String r4 = "range"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0053
            goto L_0x003d
        L_0x0053:
            r4 = 3
            goto L_0x0073
        L_0x0055:
            java.lang.String r5 = "basic"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0073
            goto L_0x003d
        L_0x005e:
            java.lang.String r4 = "open"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0067
            goto L_0x003d
        L_0x0067:
            r4 = r5
            goto L_0x0073
        L_0x0069:
            java.lang.String r4 = "list-range"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0072
            goto L_0x003d
        L_0x0072:
            r4 = 0
        L_0x0073:
            java.lang.String r3 = "max"
            java.lang.String r5 = "min"
            switch(r4) {
                case 0: goto L_0x00a2;
                case 1: goto L_0x009b;
                case 2: goto L_0x0094;
                case 3: goto L_0x0085;
                case 4: goto L_0x007b;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x000a
        L_0x007b:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RegexValidateElement r1 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RegexValidateElement
            java.lang.String r3 = r9.nextText()
            r1.<init>(r0, r3)
            goto L_0x000a
        L_0x0085:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RangeValidateElement r1 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RangeValidateElement
            java.lang.String r4 = r9.getAttributeValue(r11, r5)
            java.lang.String r3 = r9.getAttributeValue(r11, r3)
            r1.<init>(r0, r4, r3)
            goto L_0x000a
        L_0x0094:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement r1 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement
            r1.<init>(r0)
            goto L_0x000a
        L_0x009b:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$OpenValidateElement r1 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$OpenValidateElement
            r1.<init>(r0)
            goto L_0x000a
        L_0x00a2:
            org.jivesoftware.smack.datatypes.UInt32 r4 = org.jivesoftware.smack.util.ParserUtils.getUInt32Attribute(r9, r5)
            org.jivesoftware.smack.datatypes.UInt32 r3 = org.jivesoftware.smack.util.ParserUtils.getUInt32Attribute(r9, r3)
            if (r4 != 0) goto L_0x00b8
            if (r3 == 0) goto L_0x00af
            goto L_0x00b8
        L_0x00af:
            java.util.logging.Logger r3 = LOGGER
            java.lang.String r4 = "Ignoring list-range element without min or max attribute"
            r3.fine(r4)
            goto L_0x000a
        L_0x00b8:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$ListRange r2 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$ListRange
            r2.<init>((org.jivesoftware.smack.datatypes.UInt32) r4, (org.jivesoftware.smack.datatypes.UInt32) r3)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement");
    }
}
