package org.jivesoftware.smackx.vcardtemp.provider;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

public class VCardProvider extends IQProvider<VCard> {
    private static final String[] ADR = {"POSTAL", "PARCEL", "DOM", "INTL", "PREF", "POBOX", "EXTADR", "STREET", "LOCALITY", "REGION", "PCODE", "CTRY", "FF"};
    private static final String[] TEL = {"VOICE", "FAX", "PAGER", "MSG", "CELL", ShareConstants.VIDEO_URL, "BBS", "MODEM", "ISDN", "PCS", "PREF"};

    /* renamed from: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.TEXT_CHARACTERS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private static void parseAddress(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z10 = true;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z10 = false;
                } else {
                    for (String equals : ADR) {
                        if (equals.equals(name)) {
                            if (z10) {
                                vCard.setAddressFieldWork(name, xmlPullParser.nextText());
                            } else {
                                vCard.setAddressFieldHome(name, xmlPullParser.nextText());
                            }
                        }
                    }
                }
            } else if (i10 == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseEmail(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z10 = false;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (!name.equals("USERID")) {
                    if (name.equals("WORK")) {
                        z10 = true;
                    }
                } else if (z10) {
                    vCard.setEmailWork(xmlPullParser.nextText());
                } else {
                    vCard.setEmailHome(xmlPullParser.nextText());
                }
            } else if (i10 == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (r1.equals("GIVEN") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseName(org.jivesoftware.smack.xml.XmlPullParser r6, org.jivesoftware.smackx.vcardtemp.packet.VCard r7) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r6.getDepth()
        L_0x0004:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r6.next()
            int[] r2 = org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 3
            r3 = 1
            if (r1 == r3) goto L_0x001e
            if (r1 == r2) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            int r1 = r6.getDepth()
            if (r1 != r0) goto L_0x0004
            return
        L_0x001e:
            java.lang.String r1 = r6.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -2021012075: goto L_0x0059;
                case -1926781294: goto L_0x004e;
                case -1838093487: goto L_0x0043;
                case 67829597: goto L_0x003a;
                case 2066435940: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r2 = r4
            goto L_0x0063
        L_0x002f:
            java.lang.String r2 = "FAMILY"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 4
            goto L_0x0063
        L_0x003a:
            java.lang.String r3 = "GIVEN"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0063
            goto L_0x002d
        L_0x0043:
            java.lang.String r2 = "SUFFIX"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            r2 = 2
            goto L_0x0063
        L_0x004e:
            java.lang.String r2 = "PREFIX"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            r2 = r3
            goto L_0x0063
        L_0x0059:
            java.lang.String r2 = "MIDDLE"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0062
            goto L_0x002d
        L_0x0062:
            r2 = 0
        L_0x0063:
            switch(r2) {
                case 0: goto L_0x0088;
                case 1: goto L_0x007f;
                case 2: goto L_0x0077;
                case 3: goto L_0x006f;
                case 4: goto L_0x0067;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x0004
        L_0x0067:
            java.lang.String r1 = r6.nextText()
            r7.setLastName(r1)
            goto L_0x0004
        L_0x006f:
            java.lang.String r1 = r6.nextText()
            r7.setFirstName(r1)
            goto L_0x0004
        L_0x0077:
            java.lang.String r1 = r6.nextText()
            r7.setSuffix(r1)
            goto L_0x0004
        L_0x007f:
            java.lang.String r1 = r6.nextText()
            r7.setPrefix(r1)
            goto L_0x0004
        L_0x0088:
            java.lang.String r1 = r6.nextText()
            r7.setMiddleName(r1)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.parseName(org.jivesoftware.smack.xml.XmlPullParser, org.jivesoftware.smackx.vcardtemp.packet.VCard):void");
    }

    private static void parseOrg(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ORGNAME")) {
                    vCard.setOrganization(xmlPullParser.nextText());
                } else if (name.equals("ORGUNIT")) {
                    vCard.setOrganizationUnit(xmlPullParser.nextText());
                }
            } else if (i10 == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parsePhoto(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String str = null;
        String str2 = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 != 1) {
                if (i10 == 3 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("TYPE")) {
                    str2 = xmlPullParser.nextText();
                } else if (name.equals("BINVAL")) {
                    str = xmlPullParser.nextText();
                }
            }
        }
        if (str != null && str2 != null) {
            vCard.setAvatar(str, str2);
        }
    }

    private static void parseTel(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String str = null;
        boolean z10 = true;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z10 = false;
                } else if ("NUMBER".equals(name)) {
                    if (StringUtils.isNullOrEmpty((CharSequence) str)) {
                        str = "VOICE";
                    }
                    if (z10) {
                        vCard.setPhoneWork(str, xmlPullParser.nextText());
                    } else {
                        vCard.setPhoneHome(str, xmlPullParser.nextText());
                    }
                } else {
                    for (String equals : TEL) {
                        if (equals.equals(name)) {
                            str = name;
                        }
                    }
                }
            } else if (i10 == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r0.equals("ORG") == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.vcardtemp.packet.VCard parse(org.jivesoftware.smack.xml.XmlPullParser r7, int r8, org.jivesoftware.smack.packet.XmlEnvironment r9) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            org.jivesoftware.smackx.vcardtemp.packet.VCard r9 = new org.jivesoftware.smackx.vcardtemp.packet.VCard
            r9.<init>()
            r0 = 0
        L_0x0006:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r7.next()
            int[] r2 = org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0033
            if (r1 == r3) goto L_0x0023
            if (r1 == r2) goto L_0x001c
            goto L_0x0006
        L_0x001c:
            int r1 = r7.getDepth()
            if (r1 != r8) goto L_0x0006
            return r9
        L_0x0023:
            int r1 = r8 + 1
            int r2 = r7.getDepth()
            if (r1 != r2) goto L_0x0006
            java.lang.String r1 = r7.getText()
            r9.setField(r0, r1)
            goto L_0x0006
        L_0x0033:
            java.lang.String r0 = r7.getName()
            r0.hashCode()
            r1 = -1
            int r5 = r0.hashCode()
            switch(r5) {
                case -370243905: goto L_0x0090;
                case 78: goto L_0x0085;
                case 64655: goto L_0x007a;
                case 78532: goto L_0x0071;
                case 82939: goto L_0x0066;
                case 66081660: goto L_0x005b;
                case 76105234: goto L_0x0050;
                case 853317742: goto L_0x0045;
                default: goto L_0x0042;
            }
        L_0x0042:
            r2 = r1
            goto L_0x009a
        L_0x0045:
            java.lang.String r2 = "NICKNAME"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x004e
            goto L_0x0042
        L_0x004e:
            r2 = 7
            goto L_0x009a
        L_0x0050:
            java.lang.String r2 = "PHOTO"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0059
            goto L_0x0042
        L_0x0059:
            r2 = 6
            goto L_0x009a
        L_0x005b:
            java.lang.String r2 = "EMAIL"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0064
            goto L_0x0042
        L_0x0064:
            r2 = 5
            goto L_0x009a
        L_0x0066:
            java.lang.String r2 = "TEL"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x006f
            goto L_0x0042
        L_0x006f:
            r2 = 4
            goto L_0x009a
        L_0x0071:
            java.lang.String r3 = "ORG"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x009a
            goto L_0x0042
        L_0x007a:
            java.lang.String r2 = "ADR"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0083
            goto L_0x0042
        L_0x0083:
            r2 = r3
            goto L_0x009a
        L_0x0085:
            java.lang.String r2 = "N"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x008e
            goto L_0x0042
        L_0x008e:
            r2 = r4
            goto L_0x009a
        L_0x0090:
            java.lang.String r2 = "JABBERID"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0099
            goto L_0x0042
        L_0x0099:
            r2 = 0
        L_0x009a:
            switch(r2) {
                case 0: goto L_0x00c6;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00b2;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00a8;
                case 7: goto L_0x009f;
                default: goto L_0x009d;
            }
        L_0x009d:
            goto L_0x0006
        L_0x009f:
            java.lang.String r1 = r7.nextText()
            r9.setNickName(r1)
            goto L_0x0006
        L_0x00a8:
            parsePhoto(r7, r9)
            goto L_0x0006
        L_0x00ad:
            parseEmail(r7, r9)
            goto L_0x0006
        L_0x00b2:
            parseTel(r7, r9)
            goto L_0x0006
        L_0x00b7:
            parseOrg(r7, r9)
            goto L_0x0006
        L_0x00bc:
            parseAddress(r7, r9)
            goto L_0x0006
        L_0x00c1:
            parseName(r7, r9)
            goto L_0x0006
        L_0x00c6:
            java.lang.String r1 = r7.nextText()
            r9.setJabberId(r1)
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.vcardtemp.packet.VCard");
    }
}
