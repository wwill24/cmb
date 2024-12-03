package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public abstract class EmbeddedExtensionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
    /* access modifiers changed from: protected */
    public abstract PE createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list);

    public final PE parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String namespace = xmlPullParser.getNamespace();
        String name = xmlPullParser.getName();
        int attributeCount = xmlPullParser.getAttributeCount();
        HashMap hashMap = new HashMap(attributeCount);
        for (int i11 = 0; i11 < attributeCount; i11++) {
            hashMap.put(xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                PacketParserUtils.addExtensionElement((Collection<ExtensionElement>) arrayList, xmlPullParser, xmlEnvironment);
            }
            if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return createReturnExtension(name, namespace, hashMap, arrayList);
            }
        }
    }
}
