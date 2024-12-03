package org.jivesoftware.smackx.reference.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

public class ReferenceProvider extends ExtensionElementProvider<ReferenceElement> {
    public static final ReferenceProvider TEST_PROVIDER = new ReferenceProvider();

    /* JADX WARNING: type inference failed for: r9v7, types: [org.jivesoftware.smack.packet.Element] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.reference.element.ReferenceElement parse(org.jivesoftware.smack.xml.XmlPullParser r8, int r9, org.jivesoftware.smack.packet.XmlEnvironment r10) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            r7 = this;
            java.lang.String r9 = "begin"
            java.lang.Integer r1 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttribute(r8, r9)
            java.lang.String r9 = "end"
            java.lang.Integer r2 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttribute(r8, r9)
            r9 = 0
            java.lang.String r10 = "type"
            java.lang.String r10 = r8.getAttributeValue(r9, r10)
            org.jivesoftware.smackx.reference.element.ReferenceElement$Type r3 = org.jivesoftware.smackx.reference.element.ReferenceElement.Type.valueOf(r10)
            java.lang.String r10 = "anchor"
            java.lang.String r4 = r8.getAttributeValue(r9, r10)
            java.lang.String r10 = "uri"
            java.lang.String r10 = r8.getAttributeValue(r9, r10)
            if (r10 == 0) goto L_0x0033
            java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x002c }
            r0.<init>(r10)     // Catch:{ URISyntaxException -> 0x002c }
            r5 = r0
            goto L_0x0034
        L_0x002c:
            r8 = move-exception
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r8)
            throw r9
        L_0x0033:
            r5 = r9
        L_0x0034:
            r6 = r9
        L_0x0035:
            org.jivesoftware.smack.xml.XmlPullParser$Event r9 = r8.next()
            org.jivesoftware.smack.xml.XmlPullParser$Event r10 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            if (r9 != r10) goto L_0x0053
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = r8.getNamespace()
            org.jivesoftware.smack.provider.ExtensionElementProvider r9 = org.jivesoftware.smack.provider.ProviderManager.getExtensionProvider(r9, r10)
            if (r9 == 0) goto L_0x0035
            org.jivesoftware.smack.packet.Element r9 = r9.parse(r8)
            r6 = r9
            org.jivesoftware.smack.packet.ExtensionElement r6 = (org.jivesoftware.smack.packet.ExtensionElement) r6
            goto L_0x0035
        L_0x0053:
            org.jivesoftware.smack.xml.XmlPullParser$Event r10 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT
            if (r9 != r10) goto L_0x0035
            org.jivesoftware.smackx.reference.element.ReferenceElement r8 = new org.jivesoftware.smackx.reference.element.ReferenceElement
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.reference.provider.ReferenceProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.reference.element.ReferenceElement");
    }
}
