package org.jivesoftware.smackx.forward.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.delay.provider.DelayInformationProvider;
import org.jivesoftware.smackx.forward.packet.Forwarded;

public class ForwardedProvider extends ExtensionElementProvider<Forwarded<?>> {
    public static final ForwardedProvider INSTANCE = new ForwardedProvider();
    private static final Logger LOGGER = Logger.getLogger(ForwardedProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.forward.provider.ForwardedProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
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
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.forward.provider.ForwardedProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static Forwarded<Message> parseForwardedMessage(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return parseForwardedMessage(xmlPullParser, xmlPullParser.getDepth(), xmlEnvironment);
    }

    public static Forwarded<Message> parseForwardedMessage(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Forwarded<Message> parse = INSTANCE.parse(xmlPullParser, i10, xmlEnvironment);
        if (parse.isForwarded(Message.class)) {
            return parse;
        }
        throw new SmackParsingException("Expecting a forwarded message, but got " + parse);
    }

    public Forwarded<?> parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Message message = null;
        DelayInformation delayInformation = null;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 != 1) {
                if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (!name.equals(DelayInformation.ELEMENT)) {
                    if (!name.equals("message")) {
                        LOGGER.warning("Unsupported forwarded packet type: " + name);
                    } else {
                        message = PacketParserUtils.parseMessage(xmlPullParser);
                    }
                } else if (DelayInformation.NAMESPACE.equals(namespace)) {
                    delayInformation = DelayInformationProvider.INSTANCE.parse(xmlPullParser, xmlPullParser.getDepth(), (XmlEnvironment) null);
                } else {
                    LOGGER.warning("Namespace '" + namespace + "' does not match expected namespace '" + DelayInformation.NAMESPACE + "'");
                }
            }
        }
        if (message != null) {
            return new Forwarded<>(message, delayInformation);
        }
        throw new IOException("forwarded extension must contain a packet");
    }
}
