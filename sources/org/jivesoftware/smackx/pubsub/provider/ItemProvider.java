package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;

public class ItemProvider extends ExtensionElementProvider<Item> {

    /* renamed from: org.jivesoftware.smackx.pubsub.provider.ItemProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pubsub.provider.ItemProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public Item parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "id");
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, NodeElement.ELEMENT);
        Item.ItemNamespace fromXmlns = Item.ItemNamespace.fromXmlns(xmlPullParser.getNamespace());
        XmlPullParser.TagEvent nextTag = xmlPullParser.nextTag();
        int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[nextTag.ordinal()];
        if (i11 == 1) {
            ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(xmlPullParser.getName(), xmlPullParser.getNamespace());
            if (extensionProvider == null) {
                return new PayloadItem(fromXmlns, attributeValue, attributeValue2, new SimplePayload(PacketParserUtils.parseElement(xmlPullParser, true).toString()));
            }
            return new PayloadItem(fromXmlns, attributeValue, attributeValue2, (ExtensionElement) extensionProvider.parse(xmlPullParser));
        } else if (i11 == 2) {
            return new Item(fromXmlns, attributeValue, attributeValue2);
        } else {
            throw new AssertionError("unknown: " + nextTag);
        }
    }
}
