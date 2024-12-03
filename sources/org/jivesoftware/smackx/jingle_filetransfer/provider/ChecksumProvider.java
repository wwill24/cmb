package org.jivesoftware.smackx.jingle_filetransfer.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.hashes.provider.HashElementProvider;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle_filetransfer.element.Checksum;
import org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public class ChecksumProvider extends ExtensionElementProvider<Checksum> {

    /* renamed from: org.jivesoftware.smackx.jingle_filetransfer.provider.ChecksumProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle_filetransfer.provider.ChecksumProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public Checksum parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Range range;
        int i11;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "creator");
        JingleContent.Creator valueOf = attributeValue != null ? JingleContent.Creator.valueOf(attributeValue) : null;
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "name");
        JingleFileTransferChild.Builder builder = JingleFileTransferChild.getBuilder();
        HashElement hashElement = null;
        Range range2 = null;
        boolean z10 = true;
        while (z10) {
            XmlPullParser.TagEvent nextTag = xmlPullParser.nextTag();
            String text = xmlPullParser.getText();
            int i12 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[nextTag.ordinal()];
            int i13 = 0;
            if (i12 == 1) {
                text.hashCode();
                if (text.equals("hash")) {
                    hashElement = (HashElement) new HashElementProvider().parse(xmlPullParser);
                } else if (text.equals("range")) {
                    String attributeValue3 = xmlPullParser.getAttributeValue((String) null, Range.ATTR_OFFSET);
                    String attributeValue4 = xmlPullParser.getAttributeValue((String) null, Range.ATTR_LENGTH);
                    if (attributeValue3 != null) {
                        i13 = Integer.parseInt(attributeValue3);
                    }
                    if (attributeValue4 == null) {
                        i11 = -1;
                    } else {
                        i11 = Integer.parseInt(attributeValue4);
                    }
                    range = new Range(i13, i11);
                }
            } else if (i12 == 2) {
                text.hashCode();
                if (text.equals("file")) {
                    if (hashElement != null) {
                        builder.setHash(hashElement);
                    }
                    if (range2 != null) {
                        builder.setRange(range2);
                    }
                    z10 = false;
                } else if (!(!text.equals("range") || hashElement == null || range2 == null)) {
                    range = new Range(Integer.valueOf(range2.getOffset()), Integer.valueOf(range2.getLength()), hashElement);
                    hashElement = null;
                }
            }
            range2 = range;
        }
        return new Checksum(valueOf, attributeValue2, builder.build());
    }
}
