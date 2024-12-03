package org.jivesoftware.smack.parsing;

import java.io.IOException;
import java.util.LinkedHashMap;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class StandardExtensionElementProvider extends ExtensionElementProvider<StandardExtensionElement> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static StandardExtensionElementProvider INSTANCE = new StandardExtensionElementProvider();

    /* renamed from: org.jivesoftware.smack.parsing.StandardExtensionElementProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.parsing.StandardExtensionElementProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public StandardExtensionElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        StandardExtensionElement.Builder builder = StandardExtensionElement.builder(xmlPullParser.getName(), xmlPullParser.getNamespace());
        int namespaceCount = xmlPullParser.getNamespaceCount();
        int attributeCount = xmlPullParser.getAttributeCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap(namespaceCount + attributeCount);
        for (int i11 = 0; i11 < namespaceCount; i11++) {
            String namespacePrefix = xmlPullParser.getNamespacePrefix(i11);
            if (namespacePrefix != null) {
                linkedHashMap.put("xmlns:" + namespacePrefix, xmlPullParser.getNamespaceUri(i11));
            }
        }
        for (int i12 = 0; i12 < attributeCount; i12++) {
            String attributePrefix = xmlPullParser.getAttributePrefix(i12);
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (!StringUtils.isNullOrEmpty((CharSequence) attributePrefix)) {
                attributeName = attributePrefix + ':' + attributeName;
            }
            linkedHashMap.put(attributeName, attributeValue);
        }
        builder.addAttributes(linkedHashMap);
        while (true) {
            int i13 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i13 == 1) {
                builder.addElement(parse(xmlPullParser, xmlPullParser.getDepth(), xmlEnvironment));
            } else if (i13 == 2) {
                builder.setText(xmlPullParser.getText());
            } else if (i13 == 3 && i10 == xmlPullParser.getDepth()) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return builder.build();
            }
        }
    }
}
