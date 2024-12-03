package org.jivesoftware.smack.altconnections;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.DomainBareJid;

public final class HttpLookupMethod {
    private static final String XRD_NAMESPACE = "http://docs.oasis-open.org/ns/xri/xrd-1.0";

    /* renamed from: org.jivesoftware.smack.altconnections.HttpLookupMethod$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.altconnections.HttpLookupMethod.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LinkRelation {
        BOSH("urn:xmpp:alt-connections:xbosh"),
        WEBSOCKET("urn:xmpp:alt-connections:websocket");
        
        /* access modifiers changed from: private */
        public final String attribute;

        private LinkRelation(String str) {
            this.attribute = str;
        }
    }

    public static InputStream getXrdStream(DomainBareJid domainBareJid) throws IOException {
        return new URL("https://" + domainBareJid + "/.well-known/host-meta").openConnection().getInputStream();
    }

    public static List<URI> lookup(DomainBareJid domainBareJid, String str) throws IOException, XmlPullParserException, URISyntaxException {
        InputStream xrdStream = getXrdStream(domainBareJid);
        try {
            List<URI> parseXrdLinkReferencesFor = parseXrdLinkReferencesFor(PacketParserUtils.getParserFor(xrdStream), str);
            if (xrdStream != null) {
                xrdStream.close();
            }
            return parseXrdLinkReferencesFor;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static List<URI> parseXrdLinkReferencesFor(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException, URISyntaxException {
        ParserUtils.forwardToStartElement(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                String attributeValue = xmlPullParser.getAttributeValue("rel");
                if (namespace.equals(XRD_NAMESPACE) && name.equals("Link") && attributeValue.equals(str)) {
                    arrayList.add(new URI(xmlPullParser.getAttributeValue("href")));
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return arrayList;
            }
        }
    }

    public static List<URI> lookup(DomainBareJid domainBareJid, LinkRelation linkRelation) throws IOException, XmlPullParserException, URISyntaxException {
        return lookup(domainBareJid, linkRelation.attribute);
    }

    public static List<URI> parseXrdLinkReferencesFor(XmlPullParser xmlPullParser, LinkRelation linkRelation) throws IOException, XmlPullParserException, URISyntaxException {
        return parseXrdLinkReferencesFor(xmlPullParser, linkRelation.attribute);
    }
}
