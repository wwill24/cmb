package org.jivesoftware.smack.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.UnparsedIQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.parsing.StandardExtensionElementProvider;
import org.jivesoftware.smack.provider.C0522IqProvider;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.xml.SmackXmlParser;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.stringprep.XmppStringprepException;

public class PacketParserUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(PacketParserUtils.class.getName());

    /* renamed from: org.jivesoftware.smack.util.PacketParserUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                org.jivesoftware.smack.packet.IQ$Type[] r0 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r0
                r1 = 1
                org.jivesoftware.smack.packet.IQ$Type r2 = org.jivesoftware.smack.packet.IQ.Type.error     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.IQ$Type r3 = org.jivesoftware.smack.packet.IQ.Type.result     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r2
                org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.TEXT_CHARACTERS     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.PacketParserUtils.AnonymousClass1.<clinit>():void");
        }
    }

    private interface StanzaBuilderSupplier<SB extends StanzaBuilder<?>> {
        SB get(String str);
    }

    public static void addExtensionElement(StanzaBuilder<?> stanzaBuilder, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        addExtensionElement(stanzaBuilder, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static XmlPullParser getParserFor(String str) throws XmlPullParserException, IOException {
        return getParserFor((Reader) new StringReader(str));
    }

    private static <SB extends StanzaBuilder<?>> SB parseCommonStanzaAttributes(StanzaBuilderSupplier<SB> stanzaBuilderSupplier, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        SB sb2 = stanzaBuilderSupplier.get(xmlPullParser.getAttributeValue("id"));
        sb2.to(ParserUtils.getJidAttribute(xmlPullParser, "to"));
        sb2.from(ParserUtils.getJidAttribute(xmlPullParser, "from"));
        sb2.setLanguage(ParserUtils.getXmlLang(xmlPullParser, xmlEnvironment));
        return sb2;
    }

    public static Compress.Feature parseCompressionFeature(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int depth = xmlPullParser.getDepth();
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FirebaseAnalytics.Param.METHOD)) {
                    linkedList.add(xmlPullParser.nextText());
                }
            } else if (i10 != 2) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals(Compress.Feature.ELEMENT) && xmlPullParser.getDepth() == depth) {
                    return new Compress.Feature(linkedList);
                }
            }
        }
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i10) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, i10, false);
    }

    private static XmlStringBuilder parseContentDepthWithRoundtrip(XmlPullParser xmlPullParser, int i10) throws XmlPullParserException, IOException {
        boolean z10;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        boolean z11 = false;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[eventType.ordinal()];
            if (i11 == 1) {
                xmlStringBuilder.append((CharSequence) xmlPullParser.getText());
                z11 = true;
            } else if (i11 != 2) {
                CharSequence text = xmlPullParser.getText();
                if (eventType == XmlPullParser.Event.TEXT_CHARACTERS) {
                    text = StringUtils.escapeForXml(text);
                }
                xmlStringBuilder.append(text);
                z11 = false;
            } else {
                if (z11) {
                    z10 = false;
                } else {
                    z10 = z11;
                }
                if (!z11) {
                    xmlStringBuilder.append((CharSequence) xmlPullParser.getText());
                }
                if (xmlPullParser.getDepth() <= i10) {
                    return xmlStringBuilder;
                }
                z11 = z10;
            }
            eventType = xmlPullParser.next();
        }
    }

    private static CharSequence parseContentDepthWithoutRoundtrip(XmlPullParser xmlPullParser, int i10, boolean z10) throws XmlPullParserException, IOException {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        String str = null;
        boolean z11 = false;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[eventType.ordinal()];
            if (i11 == 1) {
                if (z11) {
                    xmlStringBuilder.rightAngleBracket();
                } else {
                    z11 = true;
                }
                xmlStringBuilder.halfOpenElement(xmlPullParser.getName());
                if (str == null || z10) {
                    String namespace = xmlPullParser.getNamespace();
                    if (StringUtils.isNotEmpty((CharSequence) namespace)) {
                        xmlStringBuilder.attribute("xmlns", namespace);
                        str = xmlPullParser.getName();
                    }
                }
                for (int i12 = 0; i12 < xmlPullParser.getAttributeCount(); i12++) {
                    xmlStringBuilder.attribute(xmlPullParser.getAttributeName(i12), xmlPullParser.getAttributeValue(i12));
                }
            } else if (i11 == 2) {
                if (z11) {
                    xmlStringBuilder.closeEmptyElement();
                    z11 = false;
                } else {
                    xmlStringBuilder.closeElement(xmlPullParser.getName());
                }
                if (str != null && str.equals(xmlPullParser.getName())) {
                    str = null;
                }
                if (xmlPullParser.getDepth() <= i10) {
                    return xmlStringBuilder;
                }
            } else if (i11 == 3) {
                if (z11) {
                    xmlStringBuilder.rightAngleBracket();
                    z11 = false;
                }
                xmlStringBuilder.escape(xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    public static Map<String, String> parseDescriptiveTexts(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        String xmlLang = ParserUtils.getXmlLang(xmlPullParser);
        if (xmlLang == null) {
            xmlLang = "";
        }
        String put = map.put(xmlLang, xmlPullParser.nextText());
        return map;
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseElement(xmlPullParser, false);
    }

    public static String parseElementText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser.Event next = xmlPullParser.next();
        if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
            String text = xmlPullParser.getText();
            if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT) {
                return text;
            }
            throw new XmlPullParserException("Non-empty element tag contains child-elements, while Mixed Content (XML 3.2.2) is disallowed");
        } else if (next == XmlPullParser.Event.END_ELEMENT) {
            return "";
        } else {
            throw new XmlPullParserException("Non-empty element tag not followed by text, while Mixed Content (XML 3.2.2) is disallowed");
        }
    }

    public static StanzaError parseError(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseError(xmlPullParser, (XmlEnvironment) null);
    }

    public static ExtensionElement parseExtensionElement(String str, String str2, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(str, str2);
        if (extensionProvider != null) {
            return (ExtensionElement) extensionProvider.parse(xmlPullParser, xmlEnvironment);
        }
        return (ExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser, xmlEnvironment);
    }

    public static IQ parseIQ(XmlPullParser xmlPullParser) throws Exception {
        return parseIQ(xmlPullParser, (XmlEnvironment) null);
    }

    public static IqData parseIqData(XmlPullParser xmlPullParser) throws XmppStringprepException {
        IqData buildIqData = StanzaBuilder.buildIqData(xmlPullParser.getAttributeValue("", "id"));
        buildIqData.to(ParserUtils.getJidAttribute(xmlPullParser, "to"));
        buildIqData.from(ParserUtils.getJidAttribute(xmlPullParser, "from"));
        buildIqData.ofType(IQ.Type.fromString(xmlPullParser.getAttributeValue("", "type")));
        return buildIqData;
    }

    public static Collection<String> parseMechanisms(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("mechanism")) {
                    arrayList.add(xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(Mechanisms.ELEMENT)) {
                z10 = true;
            }
        }
        return arrayList;
    }

    public static Message parseMessage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseMessage(xmlPullParser, XmlEnvironment.EMPTY);
    }

    public static Presence parsePresence(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parsePresence(xmlPullParser, XmlEnvironment.EMPTY);
    }

    public static Session.Feature parseSessionFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        boolean z10 = false;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(Session.Feature.OPTIONAL_ELEMENT)) {
                    z10 = true;
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new Session.Feature(z10);
            }
        }
    }

    public static <S extends Stanza> S parseStanza(String str) throws XmlPullParserException, SmackParsingException, IOException {
        return parseStanza(getParserFor(str), XmlEnvironment.EMPTY);
    }

    public static StartTls parseStartTlsFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        boolean z10 = false;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.Required.ELEMENT)) {
                    z10 = true;
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return new StartTls(z10);
            }
        }
    }

    public static StreamError parseStreamError(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseStreamError(xmlPullParser, (XmlEnvironment) null);
    }

    public static XmlPullParser getParserFor(InputStream inputStream) throws XmlPullParserException {
        return SmackXmlParser.newXmlParser(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i10, boolean z10) throws XmlPullParserException, IOException {
        if (xmlPullParser.supportsRoundtrip()) {
            return parseContentDepthWithRoundtrip(xmlPullParser, i10);
        }
        return parseContentDepthWithoutRoundtrip(xmlPullParser, i10, z10);
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser, boolean z10) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, xmlPullParser.getDepth(), z10);
    }

    public static StanzaError parseError(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        XmlEnvironment from = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        ArrayList arrayList = new ArrayList();
        StanzaError.Builder builder = StanzaError.getBuilder();
        builder.setType(StanzaError.Type.fromString(xmlPullParser.getAttributeValue("", "type")));
        builder.setErrorGenerator(xmlPullParser.getAttributeValue("", StanzaIdElement.ATTR_BY));
        Map<String, String> map = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (!namespace.equals("urn:ietf:params:xml:ns:xmpp-stanzas")) {
                    addExtensionElement((Collection<ExtensionElement>) arrayList, xmlPullParser, name, namespace, from);
                } else {
                    name.hashCode();
                    if (!name.equals("text")) {
                        builder.setCondition(StanzaError.Condition.fromString(name));
                        String nextText = xmlPullParser.nextText();
                        if (!nextText.isEmpty()) {
                            builder.setConditionText(nextText);
                        }
                    } else {
                        map = parseDescriptiveTexts(xmlPullParser, map);
                    }
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                ((StanzaError.Builder) builder.setExtensions(arrayList)).setDescriptiveTexts(map);
                return builder.build();
            }
        }
    }

    public static IQ parseIQ(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, XmppStringprepException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        XmlEnvironment from = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        IqData parseIqData = parseIqData(xmlPullParser);
        IQ iq = null;
        StanzaError stanzaError = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 != 1) {
                if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (!name.equals("error")) {
                    C0522IqProvider<IQ> iQProvider = ProviderManager.getIQProvider(name, namespace);
                    if (iQProvider != null) {
                        iq = iQProvider.parse(xmlPullParser, parseIqData, xmlEnvironment);
                    } else {
                        iq = new UnparsedIQ(name, namespace, parseElement(xmlPullParser));
                    }
                } else {
                    stanzaError = parseError(xmlPullParser, from);
                }
            }
        }
        if (iq == null) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[parseIqData.getType().ordinal()];
            if (i11 == 1) {
                iq = new ErrorIQ(stanzaError);
            } else if (i11 == 2) {
                iq = new EmptyResultIQ();
            }
        }
        iq.setStanzaId(parseIqData.getStanzaId());
        iq.setTo(parseIqData.getTo());
        iq.setFrom(parseIqData.getFrom());
        iq.setType(parseIqData.getType());
        iq.setError(stanzaError);
        return iq;
    }

    public static Message parseMessage(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        XmlEnvironment from = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        int depth = xmlPullParser.getDepth();
        MessageBuilder messageBuilder = (MessageBuilder) parseCommonStanzaAttributes(new k(), xmlPullParser, xmlEnvironment);
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null) {
            messageBuilder.ofType(Message.Type.fromString(attributeValue));
        }
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (!name.equals("error")) {
                    messageBuilder.addExtension(parseExtensionElement(name, namespace, xmlPullParser, from));
                } else {
                    messageBuilder.setError(parseError(xmlPullParser, from));
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return messageBuilder.build();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        if (r2.equals("show") == false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jivesoftware.smack.packet.Presence parsePresence(org.jivesoftware.smack.xml.XmlPullParser r8, org.jivesoftware.smack.packet.XmlEnvironment r9) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            org.jivesoftware.smack.util.ParserUtils.assertAtStartTag(r8)
            int r0 = r8.getDepth()
            org.jivesoftware.smack.packet.XmlEnvironment r1 = org.jivesoftware.smack.packet.XmlEnvironment.from(r8, r9)
            org.jivesoftware.smack.util.l r2 = new org.jivesoftware.smack.util.l
            r2.<init>()
            org.jivesoftware.smack.packet.StanzaBuilder r9 = parseCommonStanzaAttributes(r2, r8, r9)
            org.jivesoftware.smack.packet.PresenceBuilder r9 = (org.jivesoftware.smack.packet.PresenceBuilder) r9
            org.jivesoftware.smack.packet.Presence$Type r2 = org.jivesoftware.smack.packet.Presence.Type.available
            java.lang.String r3 = ""
            java.lang.String r4 = "type"
            java.lang.String r4 = r8.getAttributeValue(r3, r4)
            if (r4 == 0) goto L_0x002c
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x002c
            org.jivesoftware.smack.packet.Presence$Type r2 = org.jivesoftware.smack.packet.Presence.Type.fromString(r4)
        L_0x002c:
            r9.ofType(r2)
        L_0x002f:
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r8.next()
            int[] r3 = org.jivesoftware.smack.util.PacketParserUtils.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x004d
            if (r2 == r3) goto L_0x0042
            goto L_0x002f
        L_0x0042:
            int r2 = r8.getDepth()
            if (r2 != r0) goto L_0x002f
            org.jivesoftware.smack.packet.Presence r8 = r9.build()
            return r8
        L_0x004d:
            java.lang.String r2 = r8.getName()
            java.lang.String r5 = r8.getNamespace()
            r2.hashCode()
            r6 = -1
            int r7 = r2.hashCode()
            switch(r7) {
                case -1165461084: goto L_0x0081;
                case -892481550: goto L_0x0076;
                case 3529469: goto L_0x006d;
                case 96784904: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            r3 = r6
            goto L_0x008b
        L_0x0062:
            java.lang.String r3 = "error"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x006b
            goto L_0x0060
        L_0x006b:
            r3 = 3
            goto L_0x008b
        L_0x006d:
            java.lang.String r4 = "show"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x008b
            goto L_0x0060
        L_0x0076:
            java.lang.String r3 = "status"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x007f
            goto L_0x0060
        L_0x007f:
            r3 = r4
            goto L_0x008b
        L_0x0081:
            java.lang.String r3 = "priority"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x008a
            goto L_0x0060
        L_0x008a:
            r3 = 0
        L_0x008b:
            switch(r3) {
                case 0: goto L_0x00f3;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00ba;
                case 3: goto L_0x00b1;
                default: goto L_0x008e;
            }
        L_0x008e:
            org.jivesoftware.smack.packet.ExtensionElement r2 = parseExtensionElement(r2, r5, r8, r1)     // Catch:{ Exception -> 0x0096 }
            r9.addExtension(r2)     // Catch:{ Exception -> 0x0096 }
            goto L_0x002f
        L_0x0096:
            r2 = move-exception
            java.util.logging.Logger r3 = LOGGER
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse extension element in Presence stanza: "
            r5.append(r6)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r3.log(r4, r5, r2)
            goto L_0x002f
        L_0x00b1:
            org.jivesoftware.smack.packet.StanzaError r2 = parseError(r8, r1)
            r9.setError(r2)
            goto L_0x002f
        L_0x00ba:
            java.lang.String r2 = r8.nextText()
            boolean r3 = org.jivesoftware.smack.util.StringUtils.isNotEmpty((java.lang.CharSequence) r2)
            if (r3 == 0) goto L_0x00cd
            org.jivesoftware.smack.packet.Presence$Mode r2 = org.jivesoftware.smack.packet.Presence.Mode.fromString(r2)
            r9.setMode(r2)
            goto L_0x002f
        L_0x00cd:
            java.util.logging.Logger r2 = LOGGER
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Empty or null mode text in presence show element form "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r4 = "' which is invalid according to RFC6121 4.7.2.1"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.warning(r3)
            goto L_0x002f
        L_0x00ea:
            java.lang.String r2 = r8.nextText()
            r9.setStatus(r2)
            goto L_0x002f
        L_0x00f3:
            java.lang.Byte r2 = org.jivesoftware.smack.util.ParserUtils.getByteAttributeFromNextText(r8)
            r9.setPriority((java.lang.Byte) r2)
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.PacketParserUtils.parsePresence(org.jivesoftware.smack.xml.XmlPullParser, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smack.packet.Presence");
    }

    public static Stanza parseStanza(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, SmackParsingException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        String name = xmlPullParser.getName();
        name.hashCode();
        char c10 = 65535;
        switch (name.hashCode()) {
            case -1276666629:
                if (name.equals(Presence.ELEMENT)) {
                    c10 = 0;
                    break;
                }
                break;
            case 3368:
                if (name.equals(IQ.IQ_ELEMENT)) {
                    c10 = 1;
                    break;
                }
                break;
            case 954925063:
                if (name.equals("message")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return parsePresence(xmlPullParser, xmlEnvironment);
            case 1:
                return parseIQ(xmlPullParser, xmlEnvironment);
            case 2:
                return parseMessage(xmlPullParser, xmlEnvironment);
            default:
                throw new IllegalArgumentException("Can only parse message, iq or presence, not " + name);
        }
    }

    public static StreamError parseStreamError(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        XmlEnvironment from = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        StreamError.Condition condition = null;
        String str = null;
        Map<String, String> map = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (!namespace.equals(StreamError.NAMESPACE)) {
                    addExtensionElement((Collection<ExtensionElement>) arrayList, xmlPullParser, name, namespace, from);
                } else {
                    name.hashCode();
                    if (!name.equals("text")) {
                        condition = StreamError.Condition.fromString(name);
                        str = xmlPullParser.nextText();
                        if (str.isEmpty()) {
                            str = null;
                        }
                    } else {
                        map = parseDescriptiveTexts(xmlPullParser, map);
                    }
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new StreamError(condition, str, map, arrayList);
            }
        }
    }

    public static void addExtensionElement(StanzaBuilder<?> stanzaBuilder, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        stanzaBuilder.addExtension(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }

    public static XmlPullParser getParserFor(Reader reader) throws XmlPullParserException, IOException {
        XmlPullParser newXmlParser = SmackXmlParser.newXmlParser(reader);
        ParserUtils.forwardToStartElement(newXmlParser);
        return newXmlParser;
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        addExtensionElement(stanza, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        stanza.addExtension(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        addExtensionElement(collection, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        collection.add(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }
}
