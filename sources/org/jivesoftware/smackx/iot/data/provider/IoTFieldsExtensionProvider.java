package org.jivesoftware.smackx.iot.data.provider;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.validator.Var;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.IoTDataField;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.iot.data.element.TimestampElement;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.util.XmppDateTime;

public class IoTFieldsExtensionProvider extends ExtensionElementProvider<IoTFieldsExtension> {
    private static final Logger LOGGER = Logger.getLogger(IoTFieldsExtensionProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.iot.data.provider.IoTFieldsExtensionProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iot.data.provider.IoTFieldsExtensionProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public NodeElement parseNode(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackTextParseException {
        int depth = xmlPullParser.getDepth();
        NodeInfo parse = NodeInfoParser.parse(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
            if (i10 == 1) {
                name.hashCode();
                if (name.equals("timestamp")) {
                    arrayList.add(parseTimestampElement(xmlPullParser));
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new NodeElement(parse, (List<TimestampElement>) arrayList);
            }
        }
    }

    public TimestampElement parseTimestampElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackTextParseException {
        Object obj;
        int depth = xmlPullParser.getDepth();
        try {
            Date l10 = XmppDateTime.l(xmlPullParser.getAttributeValue((String) null, "value"));
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
                if (i10 == 1) {
                    String name = xmlPullParser.getName();
                    String attributeValue = xmlPullParser.getAttributeValue((String) null, "name");
                    String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "value");
                    name.hashCode();
                    if (name.equals(Var.JSTYPE_INT)) {
                        obj = new IoTDataField.IntField(attributeValue, Integer.parseInt(attributeValue2));
                    } else if (!name.equals("boolean")) {
                        Logger logger = LOGGER;
                        logger.warning("IoT Data field type '" + name + "' not implement yet. Ignoring.");
                        obj = null;
                    } else {
                        obj = new IoTDataField.BooleanField(attributeValue, Boolean.parseBoolean(attributeValue2));
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                    return new TimestampElement(l10, arrayList);
                }
            }
        } catch (ParseException e10) {
            throw new SmackParsingException.SmackTextParseException(e10);
        }
    }

    public IoTFieldsExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException.SmackTextParseException {
        int integerAttributeOrThrow = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "seqnr", "IoT data request <accepted/> without sequence number");
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "done", false);
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
            if (i11 == 1) {
                name.hashCode();
                if (name.equals(NodeElement.ELEMENT)) {
                    arrayList.add(parseNode(xmlPullParser));
                }
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                return new IoTFieldsExtension(integerAttributeOrThrow, booleanAttribute, (List<NodeElement>) arrayList);
            }
        }
    }
}
