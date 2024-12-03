package org.jivesoftware.smackx.hoxt.provider;

import java.io.IOException;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.shim.provider.HeadersProvider;

public abstract class AbstractHttpOverXmppProvider<H extends AbstractHttpOverXmpp> extends IQProvider<H> {
    private static final String ATTRIBUTE_SID = "sid";
    private static final String ATTRIBUTE_STREAM_ID = "streamId";
    static final String ATTRIBUTE_VERSION = "version";
    private static final String ELEMENT_BASE_64 = "base64";
    private static final String ELEMENT_CHUNKED_BASE_64 = "chunkedBase64";
    private static final String ELEMENT_DATA = "data";
    static final String ELEMENT_IBB = "ibb";
    static final String ELEMENT_JINGLE = "jingle";
    static final String ELEMENT_SIPUB = "sipub";
    private static final String ELEMENT_TEXT = "text";
    private static final String ELEMENT_XML = "xml";

    private static void appendXmlAttributes(XmlPullParser xmlPullParser, StringBuilder sb2) {
        int attributeCount = xmlPullParser.getAttributeCount();
        if (attributeCount > 0) {
            for (int i10 = 0; i10 < attributeCount; i10++) {
                sb2.append(' ');
                sb2.append(xmlPullParser.getAttributeName(i10));
                sb2.append("=\"");
                sb2.append(StringUtils.escapeForXml(xmlPullParser.getAttributeValue(i10)));
                sb2.append('\"');
            }
        }
    }

    private static AbstractHttpOverXmpp.Base64 parseBase64(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str = null;
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (xmlPullParser.getName().equals("base64")) {
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                str = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new AbstractHttpOverXmpp.Base64(str);
    }

    private static AbstractHttpOverXmpp.ChunkedBase64 parseChunkedBase64(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AbstractHttpOverXmpp.ChunkedBase64 chunkedBase64 = new AbstractHttpOverXmpp.ChunkedBase64(xmlPullParser.getAttributeValue("", "streamId"));
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next != XmlPullParser.Event.END_ELEMENT) {
                throw new IllegalArgumentException("unexpected event type: " + next);
            } else if (xmlPullParser.getName().equals("chunkedBase64")) {
                z10 = true;
            } else {
                throw new IllegalArgumentException("unexpected end tag: " + xmlPullParser.getName());
            }
        }
        return chunkedBase64;
    }

    private static AbstractHttpOverXmpp.Ibb parseIbb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AbstractHttpOverXmpp.Ibb ibb = new AbstractHttpOverXmpp.Ibb(xmlPullParser.getAttributeValue("", "sid"));
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next != XmlPullParser.Event.END_ELEMENT) {
                throw new IllegalArgumentException("unexpected event type: " + next);
            } else if (xmlPullParser.getName().equals("ibb")) {
                z10 = true;
            } else {
                throw new IllegalArgumentException("unexpected end tag: " + xmlPullParser.getName());
            }
        }
        return ibb;
    }

    private static AbstractHttpOverXmpp.Text parseText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str = null;
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (xmlPullParser.getName().equals("text")) {
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                str = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new AbstractHttpOverXmpp.Text(str);
    }

    private static AbstractHttpOverXmpp.Xml parseXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        while (true) {
            boolean z11 = true;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                XmlPullParser.Event event = XmlPullParser.Event.END_ELEMENT;
                if (next == event && xmlPullParser.getName().equals("xml")) {
                    z10 = true;
                } else if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (!z11) {
                        sb2.append('>');
                    }
                    sb2.append('<');
                    sb2.append(xmlPullParser.getName());
                    appendXmlAttributes(xmlPullParser, sb2);
                    z11 = false;
                } else if (next == event) {
                    if (z11) {
                        sb2.append("</");
                        sb2.append(xmlPullParser.getName());
                        sb2.append('>');
                    } else {
                        sb2.append("/>");
                    }
                } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                    if (!z11) {
                        sb2.append('>');
                        z11 = true;
                    }
                    sb2.append(StringUtils.escapeForXmlText(xmlPullParser.getText()));
                } else {
                    throw new IllegalArgumentException("unexpected eventType: " + next);
                }
            }
            return new AbstractHttpOverXmpp.Xml(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r2.equals("jingle") == false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp.Data parseData(org.jivesoftware.smack.xml.XmlPullParser r7) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r7.getEventType()
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            r2 = 0
            if (r0 != r1) goto L_0x00d6
            r0 = 0
            r1 = r0
        L_0x000b:
            if (r1 != 0) goto L_0x00d0
            org.jivesoftware.smack.xml.XmlPullParser$Event r3 = r7.next()
            org.jivesoftware.smack.xml.XmlPullParser$Event r4 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            r5 = 1
            if (r3 != r4) goto L_0x00bd
            java.lang.String r2 = r7.getName()
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1396204209: goto L_0x0067;
                case -1159928143: goto L_0x005e;
                case 104041: goto L_0x0053;
                case 118807: goto L_0x0048;
                case 3556653: goto L_0x003d;
                case 109444327: goto L_0x0032;
                case 1970784315: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            r5 = r3
            goto L_0x0071
        L_0x0027:
            java.lang.String r4 = "chunkedBase64"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0030
            goto L_0x0025
        L_0x0030:
            r5 = 6
            goto L_0x0071
        L_0x0032:
            java.lang.String r4 = "sipub"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x003b
            goto L_0x0025
        L_0x003b:
            r5 = 5
            goto L_0x0071
        L_0x003d:
            java.lang.String r4 = "text"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0046
            goto L_0x0025
        L_0x0046:
            r5 = 4
            goto L_0x0071
        L_0x0048:
            java.lang.String r4 = "xml"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0051
            goto L_0x0025
        L_0x0051:
            r5 = 3
            goto L_0x0071
        L_0x0053:
            java.lang.String r4 = "ibb"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x005c
            goto L_0x0025
        L_0x005c:
            r5 = 2
            goto L_0x0071
        L_0x005e:
            java.lang.String r4 = "jingle"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0071
            goto L_0x0025
        L_0x0067:
            java.lang.String r4 = "base64"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0070
            goto L_0x0025
        L_0x0070:
            r5 = r0
        L_0x0071:
            switch(r5) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x00af;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a3;
                case 4: goto L_0x009d;
                case 5: goto L_0x0095;
                case 6: goto L_0x008f;
                default: goto L_0x0074;
            }
        L_0x0074:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unsupported child tag: "
            r1.append(r2)
            java.lang.String r7 = r7.getName()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x008f:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$ChunkedBase64 r2 = parseChunkedBase64(r7)
            goto L_0x000b
        L_0x0095:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "sipub is not supported yet"
            r7.<init>(r0)
            throw r7
        L_0x009d:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Text r2 = parseText(r7)
            goto L_0x000b
        L_0x00a3:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Xml r2 = parseXml(r7)
            goto L_0x000b
        L_0x00a9:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Ibb r2 = parseIbb(r7)
            goto L_0x000b
        L_0x00af:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "jingle is not supported yet"
            r7.<init>(r0)
            throw r7
        L_0x00b7:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Base64 r2 = parseBase64(r7)
            goto L_0x000b
        L_0x00bd:
            org.jivesoftware.smack.xml.XmlPullParser$Event r4 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT
            if (r3 != r4) goto L_0x000b
            java.lang.String r3 = r7.getName()
            java.lang.String r4 = "data"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x000b
            r1 = r5
            goto L_0x000b
        L_0x00d0:
            org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Data r7 = new org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Data
            r7.<init>(r2)
            r2 = r7
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.hoxt.provider.AbstractHttpOverXmppProvider.parseData(org.jivesoftware.smack.xml.XmlPullParser):org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp$Data");
    }

    /* access modifiers changed from: protected */
    public HeadersExtension parseHeaders(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, SmackParsingException {
        if (xmlPullParser.next() != XmlPullParser.Event.START_ELEMENT || !xmlPullParser.getName().equals(HeadersExtension.ELEMENT)) {
            return null;
        }
        HeadersExtension headersExtension = (HeadersExtension) HeadersProvider.INSTANCE.parse(xmlPullParser);
        xmlPullParser.next();
        return headersExtension;
    }
}
