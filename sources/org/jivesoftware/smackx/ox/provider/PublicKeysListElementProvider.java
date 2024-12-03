package org.jivesoftware.smackx.ox.provider;

import en.a;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;

public final class PublicKeysListElementProvider extends ExtensionElementProvider<PublicKeysListElement> {
    public static final PublicKeysListElementProvider TEST_INSTANCE = new PublicKeysListElementProvider();

    /* renamed from: org.jivesoftware.smackx.ox.provider.PublicKeysListElementProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.provider.PublicKeysListElementProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public PublicKeysListElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException.SmackTextParseException {
        PublicKeysListElement.Builder builder = PublicKeysListElement.builder();
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i11 != 1) {
                if (i11 == 2 && xmlPullParser.getName().equals(PublicKeysListElement.ELEMENT)) {
                    return builder.build();
                }
            } else if (PublicKeysListElement.PubkeyMetadataElement.ELEMENT.equals(xmlPullParser.getName())) {
                builder.addMetadata(new PublicKeysListElement.PubkeyMetadataElement(new a(xmlPullParser.getAttributeValue((String) null, PublicKeysListElement.PubkeyMetadataElement.ATTR_V4_FINGERPRINT)), ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue((String) null, "date"))));
            }
        }
    }
}
