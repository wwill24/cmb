package org.jivesoftware.smackx.iot.control.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.iot.control.element.IoTSetRequest;

public class IoTSetRequestProvider extends IQProvider<IoTSetRequest> {

    /* renamed from: org.jivesoftware.smackx.iot.control.provider.IoTSetRequestProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iot.control.provider.IoTSetRequestProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r0.equals(com.leanplum.internal.Constants.Kinds.BOOLEAN) == false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.iot.control.element.IoTSetRequest parse(org.jivesoftware.smack.xml.XmlPullParser r6, int r7, org.jivesoftware.smack.packet.XmlEnvironment r8) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            java.util.ArrayList r8 = new java.util.ArrayList
            r0 = 4
            r8.<init>(r0)
        L_0x0006:
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r6.next()
            int[] r1 = org.jivesoftware.smackx.iot.control.provider.IoTSetRequestProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0025
            if (r0 == r1) goto L_0x0019
            goto L_0x0006
        L_0x0019:
            int r0 = r6.getDepth()
            if (r0 != r7) goto L_0x0006
            org.jivesoftware.smackx.iot.control.element.IoTSetRequest r6 = new org.jivesoftware.smackx.iot.control.element.IoTSetRequest
            r6.<init>(r8)
            return r6
        L_0x0025:
            java.lang.String r0 = r6.getName()
            r0.hashCode()
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1325958191: goto L_0x0055;
                case 104431: goto L_0x004a;
                case 3029738: goto L_0x0041;
                case 3327612: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            r1 = r3
            goto L_0x005f
        L_0x0036:
            java.lang.String r1 = "long"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003f
            goto L_0x0034
        L_0x003f:
            r1 = 3
            goto L_0x005f
        L_0x0041:
            java.lang.String r2 = "bool"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x005f
            goto L_0x0034
        L_0x004a:
            java.lang.String r1 = "int"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0053
            goto L_0x0034
        L_0x0053:
            r1 = r2
            goto L_0x005f
        L_0x0055:
            java.lang.String r1 = "double"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005e
            goto L_0x0034
        L_0x005e:
            r1 = 0
        L_0x005f:
            java.lang.String r0 = "value"
            java.lang.String r2 = "name"
            r3 = 0
            switch(r1) {
                case 0: goto L_0x00a9;
                case 1: goto L_0x0093;
                case 2: goto L_0x007d;
                case 3: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0006
        L_0x0068:
            java.lang.String r1 = r6.getAttributeValue(r3, r2)
            java.lang.String r0 = r6.getAttributeValue(r3, r0)
            long r2 = java.lang.Long.parseLong(r0)
            org.jivesoftware.smackx.iot.control.element.SetLongData r0 = new org.jivesoftware.smackx.iot.control.element.SetLongData
            r0.<init>((java.lang.String) r1, (long) r2)
            r8.add(r0)
            goto L_0x0006
        L_0x007d:
            java.lang.String r1 = r6.getAttributeValue(r3, r2)
            java.lang.String r0 = r6.getAttributeValue(r3, r0)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            org.jivesoftware.smackx.iot.control.element.SetBoolData r2 = new org.jivesoftware.smackx.iot.control.element.SetBoolData
            r2.<init>((java.lang.String) r1, (boolean) r0)
            r8.add(r2)
            goto L_0x0006
        L_0x0093:
            java.lang.String r1 = r6.getAttributeValue(r3, r2)
            java.lang.String r0 = r6.getAttributeValue(r3, r0)
            int r0 = java.lang.Integer.parseInt(r0)
            org.jivesoftware.smackx.iot.control.element.SetIntData r2 = new org.jivesoftware.smackx.iot.control.element.SetIntData
            r2.<init>((java.lang.String) r1, (int) r0)
            r8.add(r2)
            goto L_0x0006
        L_0x00a9:
            java.lang.String r1 = r6.getAttributeValue(r3, r2)
            java.lang.String r0 = r6.getAttributeValue(r3, r0)
            double r2 = java.lang.Double.parseDouble(r0)
            org.jivesoftware.smackx.iot.control.element.SetDoubleData r0 = new org.jivesoftware.smackx.iot.control.element.SetDoubleData
            r0.<init>((java.lang.String) r1, (double) r2)
            r8.add(r0)
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iot.control.provider.IoTSetRequestProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.iot.control.element.IoTSetRequest");
    }
}
