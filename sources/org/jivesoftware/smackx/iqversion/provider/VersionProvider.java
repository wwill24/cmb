package org.jivesoftware.smackx.iqversion.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.iqversion.packet.Version;

public class VersionProvider extends IQProvider<Version> {

    /* renamed from: org.jivesoftware.smackx.iqversion.provider.VersionProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iqversion.provider.VersionProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r2.equals(com.facebook.internal.ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION) == false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.iqversion.packet.Version parse(org.jivesoftware.smack.xml.XmlPullParser r8, int r9, org.jivesoftware.smack.packet.XmlEnvironment r10) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r7 = this;
            r10 = 0
            r0 = r10
            r1 = r0
        L_0x0003:
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r8.next()
            int[] r3 = org.jivesoftware.smackx.iqversion.provider.VersionProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x003a
            if (r2 == r3) goto L_0x0016
            goto L_0x0003
        L_0x0016:
            int r2 = r8.getDepth()
            if (r2 != r9) goto L_0x0003
            java.lang.String r2 = r8.getName()
            java.lang.String r3 = "query"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0003
            if (r10 != 0) goto L_0x0034
            if (r0 != 0) goto L_0x0034
            if (r1 != 0) goto L_0x0034
            org.jivesoftware.smackx.iqversion.packet.Version r8 = new org.jivesoftware.smackx.iqversion.packet.Version
            r8.<init>()
            return r8
        L_0x0034:
            org.jivesoftware.smackx.iqversion.packet.Version r8 = new org.jivesoftware.smackx.iqversion.packet.Version
            r8.<init>(r10, r0, r1)
            return r8
        L_0x003a:
            java.lang.String r2 = r8.getName()
            r2.hashCode()
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 3556: goto L_0x005f;
                case 3373707: goto L_0x0054;
                case 351608024: goto L_0x004b;
                default: goto L_0x0049;
            }
        L_0x0049:
            r3 = r5
            goto L_0x0069
        L_0x004b:
            java.lang.String r4 = "version"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0069
            goto L_0x0049
        L_0x0054:
            java.lang.String r3 = "name"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x005d
            goto L_0x0049
        L_0x005d:
            r3 = r4
            goto L_0x0069
        L_0x005f:
            java.lang.String r3 = "os"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0068
            goto L_0x0049
        L_0x0068:
            r3 = 0
        L_0x0069:
            switch(r3) {
                case 0: goto L_0x0077;
                case 1: goto L_0x0072;
                case 2: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x0003
        L_0x006d:
            java.lang.String r0 = r8.nextText()
            goto L_0x0003
        L_0x0072:
            java.lang.String r10 = r8.nextText()
            goto L_0x0003
        L_0x0077:
            java.lang.String r1 = r8.nextText()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iqversion.provider.VersionProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.iqversion.packet.Version");
    }
}
