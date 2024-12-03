package org.jivesoftware.smackx.jingle.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.C0522IqProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public class JingleProvider extends C0522IqProvider<Jingle> {
    private static final Logger LOGGER = Logger.getLogger(JingleProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.jingle.provider.JingleProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent[] r0 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = r0
                r1 = 1
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r2 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r3 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.provider.JingleProvider.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [org.jivesoftware.smack.packet.Element] */
    /* JADX WARNING: type inference failed for: r1v12, types: [org.jivesoftware.smack.packet.Element] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jivesoftware.smackx.jingle.element.JingleContent parseJingleContent(org.jivesoftware.smack.xml.XmlPullParser r5, int r6) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            org.jivesoftware.smackx.jingle.element.JingleContent$Builder r0 = org.jivesoftware.smackx.jingle.element.JingleContent.getBuilder()
            java.lang.String r1 = ""
            java.lang.String r2 = "creator"
            java.lang.String r2 = r5.getAttributeValue(r1, r2)
            org.jivesoftware.smackx.jingle.element.JingleContent$Creator r2 = org.jivesoftware.smackx.jingle.element.JingleContent.Creator.valueOf(r2)
            r0.setCreator(r2)
            java.lang.String r2 = "disposition"
            java.lang.String r2 = r5.getAttributeValue(r1, r2)
            r0.setDisposition(r2)
            java.lang.String r2 = "name"
            java.lang.String r2 = r5.getAttributeValue(r1, r2)
            r0.setName(r2)
            java.lang.String r2 = "senders"
            java.lang.String r1 = r5.getAttributeValue(r1, r2)
            if (r1 == 0) goto L_0x0034
            org.jivesoftware.smackx.jingle.element.JingleContent$Senders r1 = org.jivesoftware.smackx.jingle.element.JingleContent.Senders.valueOf(r1)
            r0.setSenders(r1)
        L_0x0034:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = r5.next()
            int[] r2 = org.jivesoftware.smackx.jingle.provider.JingleProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0052
            r2 = 2
            if (r1 == r2) goto L_0x0047
            goto L_0x0034
        L_0x0047:
            int r1 = r5.getDepth()
            if (r1 != r6) goto L_0x0034
            org.jivesoftware.smackx.jingle.element.JingleContent r5 = r0.build()
            return r5
        L_0x0052:
            java.lang.String r1 = r5.getName()
            java.lang.String r2 = r5.getNamespace()
            r1.hashCode()
            java.lang.String r3 = "description"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00a3
            java.lang.String r3 = "transport"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0084
            java.util.logging.Logger r2 = LOGGER
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown Jingle content element: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.severe(r1)
            goto L_0x0034
        L_0x0084:
            org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider r1 = org.jivesoftware.smackx.jingle.provider.JingleContentProviderManager.getJingleContentTransportProvider(r2)
            if (r1 != 0) goto L_0x0098
            org.jivesoftware.smack.parsing.StandardExtensionElementProvider r1 = org.jivesoftware.smack.parsing.StandardExtensionElementProvider.INSTANCE
            org.jivesoftware.smack.packet.Element r1 = r1.parse(r5)
            org.jivesoftware.smack.packet.StandardExtensionElement r1 = (org.jivesoftware.smack.packet.StandardExtensionElement) r1
            org.jivesoftware.smackx.jingle.element.UnknownJingleContentTransport r2 = new org.jivesoftware.smackx.jingle.element.UnknownJingleContentTransport
            r2.<init>(r1)
            goto L_0x009f
        L_0x0098:
            org.jivesoftware.smack.packet.Element r1 = r1.parse(r5)
            r2 = r1
            org.jivesoftware.smackx.jingle.element.JingleContentTransport r2 = (org.jivesoftware.smackx.jingle.element.JingleContentTransport) r2
        L_0x009f:
            r0.setTransport(r2)
            goto L_0x0034
        L_0x00a3:
            org.jivesoftware.smackx.jingle.provider.JingleContentDescriptionProvider r1 = org.jivesoftware.smackx.jingle.provider.JingleContentProviderManager.getJingleContentDescriptionProvider(r2)
            if (r1 != 0) goto L_0x00b7
            org.jivesoftware.smack.parsing.StandardExtensionElementProvider r1 = org.jivesoftware.smack.parsing.StandardExtensionElementProvider.INSTANCE
            org.jivesoftware.smack.packet.Element r1 = r1.parse(r5)
            org.jivesoftware.smack.packet.StandardExtensionElement r1 = (org.jivesoftware.smack.packet.StandardExtensionElement) r1
            org.jivesoftware.smackx.jingle.element.UnknownJingleContentDescription r2 = new org.jivesoftware.smackx.jingle.element.UnknownJingleContentDescription
            r2.<init>(r1)
            goto L_0x00be
        L_0x00b7:
            org.jivesoftware.smack.packet.Element r1 = r1.parse(r5)
            r2 = r1
            org.jivesoftware.smackx.jingle.element.JingleContentDescription r2 = (org.jivesoftware.smackx.jingle.element.JingleContentDescription) r2
        L_0x00be:
            r0.setDescription(r2)
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.provider.JingleProvider.parseJingleContent(org.jivesoftware.smack.xml.XmlPullParser, int):org.jivesoftware.smackx.jingle.element.JingleContent");
    }

    public static JingleReason parseJingleReason(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        String namespace = xmlPullParser.getNamespace();
        String str = null;
        JingleReason.Reason reason = null;
        String str2 = null;
        ExtensionElement extensionElement = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 != 1) {
                if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                String namespace2 = xmlPullParser.getNamespace();
                if (namespace2.equals(namespace)) {
                    name.hashCode();
                    if (name.equals("text")) {
                        str2 = xmlPullParser.nextText();
                    } else if (!name.equals("alternative-session")) {
                        reason = JingleReason.Reason.fromString(name);
                    } else {
                        xmlPullParser.next();
                        str = xmlPullParser.nextText();
                    }
                } else {
                    extensionElement = PacketParserUtils.parseExtensionElement(name, namespace2, xmlPullParser, (XmlEnvironment) null);
                }
            }
        }
        if (str != null) {
            return new JingleReason.AlternativeSession(str, str2, extensionElement);
        }
        return new JingleReason(reason, str2, extensionElement);
    }

    public Jingle parse(XmlPullParser xmlPullParser, int i10, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Jingle.Builder builder = Jingle.builder(iqData);
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue != null) {
            builder.setAction(JingleAction.fromString(attributeValue));
        }
        builder.setInitiator(ParserUtils.getFullJidAttribute(xmlPullParser, Jingle.INITIATOR_ATTRIBUTE_NAME));
        builder.setResponder(ParserUtils.getFullJidAttribute(xmlPullParser, Jingle.RESPONDER_ATTRIBUTE_NAME));
        builder.setSessionId(xmlPullParser.getAttributeValue("", "sid"));
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(JingleReason.ELEMENT)) {
                    builder.setReason(parseJingleReason(xmlPullParser));
                } else if (!name.equals("content")) {
                    Logger logger = LOGGER;
                    logger.severe("Unknown Jingle element: " + name);
                } else {
                    builder.addJingleContent(parseJingleContent(xmlPullParser, xmlPullParser.getDepth()));
                }
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                return builder.build();
            }
        }
    }
}
