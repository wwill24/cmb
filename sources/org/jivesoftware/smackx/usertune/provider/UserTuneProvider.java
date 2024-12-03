package org.jivesoftware.smackx.usertune.provider;

import com.leanplum.internal.RequestBuilder;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.jivesoftware.smackx.usertune.element.UserTuneElement;

public class UserTuneProvider extends ExtensionElementProvider<UserTuneElement> {
    public static final UserTuneProvider INSTANCE = new UserTuneProvider();

    /* renamed from: org.jivesoftware.smackx.usertune.provider.UserTuneProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.usertune.provider.UserTuneProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public UserTuneElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        UserTuneElement.Builder builder = UserTuneElement.getBuilder();
        XmlPullParser.TagEvent nextTag = xmlPullParser.nextTag();
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[nextTag.ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                if ("http://jabber.org/protocol/tune".equals(xmlPullParser.getNamespace())) {
                    while (nextTag == XmlPullParser.TagEvent.START_ELEMENT) {
                        name.hashCode();
                        char c10 = 65535;
                        switch (name.hashCode()) {
                            case -1409097913:
                                if (name.equals("artist")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case -1106363674:
                                if (name.equals(Range.ATTR_LENGTH)) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case -938102371:
                                if (name.equals("rating")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case -896505829:
                                if (name.equals("source")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                            case 116076:
                                if (name.equals("uri")) {
                                    c10 = 4;
                                    break;
                                }
                                break;
                            case 110371416:
                                if (name.equals("title")) {
                                    c10 = 5;
                                    break;
                                }
                                break;
                            case 110621003:
                                if (name.equals(RequestBuilder.ACTION_TRACK)) {
                                    c10 = 6;
                                    break;
                                }
                                break;
                        }
                        switch (c10) {
                            case 0:
                                builder.setArtist(xmlPullParser.nextText());
                                break;
                            case 1:
                                builder.setLength(ParserUtils.getIntegerFromNextText(xmlPullParser));
                                break;
                            case 2:
                                builder.setRating(ParserUtils.getIntegerFromNextText(xmlPullParser));
                                break;
                            case 3:
                                builder.setSource(xmlPullParser.nextText());
                                break;
                            case 4:
                                builder.setUri(ParserUtils.getUriFromNextText(xmlPullParser));
                                break;
                            case 5:
                                builder.setTitle(xmlPullParser.nextText());
                                break;
                            case 6:
                                builder.setTrack(xmlPullParser.nextText());
                                break;
                        }
                        nextTag = xmlPullParser.nextTag();
                        name = xmlPullParser.getName();
                    }
                }
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                return builder.build();
            }
        }
    }
}
