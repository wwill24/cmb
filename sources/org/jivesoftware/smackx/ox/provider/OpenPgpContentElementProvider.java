package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpContentElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jxmpp.jid.Jid;

public abstract class OpenPgpContentElementProvider<O extends OpenPgpContentElement> extends ExtensionElementProvider<O> {
    private static final Logger LOGGER = Logger.getLogger(OpenPgpContentElementProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.AnonymousClass1.<clinit>():void");
        }
    }

    protected static final class OpenPgpContentElementData {
        protected final List<ExtensionElement> payload;
        protected final String rpad;
        protected final Date timestamp;
        protected final Set<Jid> to;

        /* synthetic */ OpenPgpContentElementData(Set set, Date date, String str, List list, AnonymousClass1 r52) {
            this(set, date, str, list);
        }

        private OpenPgpContentElementData(Set<Jid> set, Date date, String str, List<ExtensionElement> list) {
            this.to = set;
            this.timestamp = date;
            this.rpad = str;
            this.payload = list;
        }
    }

    public static OpenPgpContentElement parseOpenPgpContentElement(String str) throws XmlPullParserException, IOException {
        return parseOpenPgpContentElement(PacketParserUtils.getParserFor(str));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r0.equals(org.jivesoftware.smackx.ox.element.SignElement.ELEMENT) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        if (r0.equals("payload") == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        if (r12 == 1) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d1, code lost:
        if (r12 == 2) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        r12 = org.jivesoftware.smack.provider.ProviderManager.getExtensionProvider(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        if (r12 != null) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00da, code lost:
        LOGGER.log(java.util.logging.Level.INFO, "No provider found for " + r0 + " " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fb, code lost:
        r4.add((org.jivesoftware.smack.packet.ExtensionElement) r12.parse(r11));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.OpenPgpContentElementData parseOpenPgpContentElementData(org.jivesoftware.smack.xml.XmlPullParser r11, int r12) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            r12 = 0
            r2 = r12
            r3 = r2
        L_0x000d:
            org.jivesoftware.smack.xml.XmlPullParser$Event r12 = r11.next()
            java.lang.String r0 = r11.getName()
            int[] r5 = org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r12 = r12.ordinal()
            r12 = r5[r12]
            r5 = 0
            r6 = -1
            r7 = 2
            r8 = 1
            if (r12 == r8) goto L_0x005d
            if (r12 == r7) goto L_0x0026
            goto L_0x000d
        L_0x0026:
            r0.hashCode()
            int r12 = r0.hashCode()
            switch(r12) {
                case 3530173: goto L_0x0048;
                case 94944622: goto L_0x003d;
                case 1075375569: goto L_0x0032;
                default: goto L_0x0030;
            }
        L_0x0030:
            r5 = r6
            goto L_0x0051
        L_0x0032:
            java.lang.String r12 = "signcrypt"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x003b
            goto L_0x0030
        L_0x003b:
            r5 = r7
            goto L_0x0051
        L_0x003d:
            java.lang.String r12 = "crypt"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x0046
            goto L_0x0030
        L_0x0046:
            r5 = r8
            goto L_0x0051
        L_0x0048:
            java.lang.String r12 = "sign"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x0051
            goto L_0x0030
        L_0x0051:
            switch(r5) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0055;
                case 2: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x000d
        L_0x0055:
            org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$OpenPgpContentElementData r11 = new org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$OpenPgpContentElementData
            r5 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return r11
        L_0x005d:
            r0.hashCode()
            int r12 = r0.hashCode()
            switch(r12) {
                case -786701938: goto L_0x008a;
                case 3707: goto L_0x007f;
                case 3506913: goto L_0x0074;
                case 3560141: goto L_0x0069;
                default: goto L_0x0067;
            }
        L_0x0067:
            r5 = r6
            goto L_0x0093
        L_0x0069:
            java.lang.String r12 = "time"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x0072
            goto L_0x0067
        L_0x0072:
            r5 = 3
            goto L_0x0093
        L_0x0074:
            java.lang.String r12 = "rpad"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x007d
            goto L_0x0067
        L_0x007d:
            r5 = r7
            goto L_0x0093
        L_0x007f:
            java.lang.String r12 = "to"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x0088
            goto L_0x0067
        L_0x0088:
            r5 = r8
            goto L_0x0093
        L_0x008a:
            java.lang.String r12 = "payload"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x0093
            goto L_0x0067
        L_0x0093:
            java.lang.String r12 = ""
            switch(r5) {
                case 0: goto L_0x00bb;
                case 1: goto L_0x00ac;
                case 2: goto L_0x00a6;
                case 3: goto L_0x009a;
                default: goto L_0x0098;
            }
        L_0x0098:
            goto L_0x000d
        L_0x009a:
            java.lang.String r0 = "stamp"
            java.lang.String r12 = r11.getAttributeValue(r12, r0)
            java.util.Date r2 = org.jivesoftware.smack.util.ParserUtils.getDateFromXep82String(r12)
            goto L_0x000d
        L_0x00a6:
            java.lang.String r3 = r11.nextText()
            goto L_0x000d
        L_0x00ac:
            java.lang.String r0 = "jid"
            java.lang.String r12 = r11.getAttributeValue(r12, r0)
            org.jxmpp.jid.BareJid r12 = org.jxmpp.jid.impl.a.b(r12)
            r1.add(r12)
            goto L_0x000d
        L_0x00bb:
            org.jivesoftware.smack.xml.XmlPullParser$Event r12 = r11.next()
            java.lang.String r0 = r11.getName()
            java.lang.String r5 = r11.getNamespace()
            int[] r6 = org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r12 = r12.ordinal()
            r12 = r6[r12]
            if (r12 == r8) goto L_0x00d4
            if (r12 == r7) goto L_0x000d
            goto L_0x00bb
        L_0x00d4:
            org.jivesoftware.smack.provider.ExtensionElementProvider r12 = org.jivesoftware.smack.provider.ProviderManager.getExtensionProvider(r0, r5)
            if (r12 != 0) goto L_0x00fb
            java.util.logging.Logger r12 = LOGGER
            java.util.logging.Level r6 = java.util.logging.Level.INFO
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "No provider found for "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = " "
            r9.append(r0)
            r9.append(r5)
            java.lang.String r0 = r9.toString()
            r12.log(r6, r0)
            goto L_0x00bb
        L_0x00fb:
            org.jivesoftware.smack.packet.Element r12 = r12.parse(r11)
            org.jivesoftware.smack.packet.ExtensionElement r12 = (org.jivesoftware.smack.packet.ExtensionElement) r12
            r4.add(r12)
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.parseOpenPgpContentElementData(org.jivesoftware.smack.xml.XmlPullParser, int):org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$OpenPgpContentElementData");
    }

    public abstract O parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public static OpenPgpContentElement parseOpenPgpContentElement(XmlPullParser xmlPullParser) throws XmlPullParserException {
        try {
            String name = xmlPullParser.getName();
            char c10 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 3530173) {
                if (hashCode != 94944622) {
                    if (hashCode == 1075375569) {
                        if (name.equals(SigncryptElement.ELEMENT)) {
                            c10 = 0;
                        }
                    }
                } else if (name.equals(CryptElement.ELEMENT)) {
                    c10 = 2;
                }
            } else if (name.equals(SignElement.ELEMENT)) {
                c10 = 1;
            }
            if (c10 == 0) {
                return (OpenPgpContentElement) SigncryptElementProvider.INSTANCE.parse(xmlPullParser);
            }
            if (c10 == 1) {
                return (OpenPgpContentElement) SignElementProvider.INSTANCE.parse(xmlPullParser);
            }
            if (c10 == 2) {
                return (OpenPgpContentElement) CryptElementProvider.INSTANCE.parse(xmlPullParser);
            }
            throw new XmlPullParserException("Expected <crypt/>, <sign/> or <signcrypt/> element, but got neither of them.");
        } catch (Exception e10) {
            throw new XmlPullParserException(e10.getMessage());
        }
    }
}
