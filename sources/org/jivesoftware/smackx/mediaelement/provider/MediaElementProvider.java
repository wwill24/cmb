package org.jivesoftware.smackx.mediaelement.provider;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mediaelement.element.MediaElement;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;

public class MediaElementProvider extends FormFieldChildElementProvider<MediaElement> {
    private static final Logger LOGGER = Logger.getLogger(MediaElementProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.mediaelement.provider.MediaElementProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.mediaelement.provider.MediaElementProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private static MediaElement.Uri parseUri(XmlPullParser xmlPullParser) throws SmackParsingException.SmackUriSyntaxParsingException, XmlPullParserException, IOException {
        return new MediaElement.Uri(ParserUtils.getUriFromNextText(xmlPullParser), xmlPullParser.getAttributeValue("type"));
    }

    public QName getQName() {
        return MediaElement.QNAME;
    }

    public MediaElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException.SmackUriSyntaxParsingException {
        UInt16 uInt16Attribute = ParserUtils.getUInt16Attribute(xmlPullParser, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        UInt16 uInt16Attribute2 = ParserUtils.getUInt16Attribute(xmlPullParser, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        MediaElement.Builder builder = MediaElement.builder();
        if (uInt16Attribute != null && uInt16Attribute2 != null) {
            builder.setHeightAndWidth(uInt16Attribute, uInt16Attribute2);
        } else if (!(uInt16Attribute == null && uInt16Attribute2 == null)) {
            LOGGER.warning("Only one of height and width set while parsing media element");
        }
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i11 != 1) {
                if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                    return builder.build();
                }
            } else if (xmlPullParser.getQName().equals(MediaElement.Uri.QNAME)) {
                builder.addUri(parseUri(xmlPullParser));
            }
        }
    }
}
