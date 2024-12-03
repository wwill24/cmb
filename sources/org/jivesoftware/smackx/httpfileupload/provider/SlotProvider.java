package org.jivesoftware.smackx.httpfileupload.provider;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager;
import org.jivesoftware.smackx.httpfileupload.UploadService;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.httpfileupload.element.Slot_V0_2;
import org.jivesoftware.smackx.shim.packet.Header;

public class SlotProvider extends IQProvider<Slot> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: org.jivesoftware.smackx.httpfileupload.provider.SlotProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                r1 = 1
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.jivesoftware.smackx.httpfileupload.UploadService$Version[] r2 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version = r2
                org.jivesoftware.smackx.httpfileupload.UploadService$Version r3 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.v0_2     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.jivesoftware.smackx.httpfileupload.UploadService$Version r2 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.v0_3     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.httpfileupload.provider.SlotProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class PutElement_V0_4_Content {
        /* access modifiers changed from: private */
        public final Map<String, String> headers;
        /* access modifiers changed from: private */
        public final URL putUrl;

        /* synthetic */ PutElement_V0_4_Content(URL url, Map map, AnonymousClass1 r32) {
            this(url, map);
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public URL getPutUrl() {
            return this.putUrl;
        }

        private PutElement_V0_4_Content(URL url, Map<String, String> map) {
            this.putUrl = url;
            this.headers = map;
        }
    }

    public static PutElement_V0_4_Content parsePutElement_V0_4(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        URL url = new URL(xmlPullParser.getAttributeValue((String) null, "url"));
        HashMap hashMap = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(Header.ELEMENT)) {
                    String requiredAttribute = ParserUtils.getRequiredAttribute(xmlPullParser, "name");
                    String requiredNextText = ParserUtils.getRequiredNextText(xmlPullParser);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(requiredAttribute, requiredNextText);
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new PutElement_V0_4_Content(url, hashMap, (AnonymousClass1) null);
            }
        }
    }

    public Slot parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String str;
        UploadService.Version namespaceToVersion = HttpFileUploadManager.namespaceToVersion(xmlPullParser.getNamespace());
        URL url = null;
        URL url2 = null;
        PutElement_V0_4_Content putElement_V0_4_Content = null;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("get")) {
                    int i12 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[namespaceToVersion.ordinal()];
                    if (i12 == 1) {
                        str = xmlPullParser.nextText();
                    } else if (i12 == 2) {
                        str = xmlPullParser.getAttributeValue((String) null, "url");
                    } else {
                        throw new AssertionError();
                    }
                    url2 = new URL(str);
                } else if (name.equals("put")) {
                    int i13 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[namespaceToVersion.ordinal()];
                    if (i13 == 1) {
                        url = new URL(xmlPullParser.nextText());
                    } else if (i13 == 2) {
                        putElement_V0_4_Content = parsePutElement_V0_4(xmlPullParser);
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    continue;
                }
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                int i14 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[namespaceToVersion.ordinal()];
                if (i14 == 1) {
                    return new Slot_V0_2(url, url2);
                }
                if (i14 == 2) {
                    return new Slot(putElement_V0_4_Content.putUrl, url2, putElement_V0_4_Content.headers);
                }
                throw new AssertionError();
            }
        }
    }
}
