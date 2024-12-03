package org.jivesoftware.smackx.xdata.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.BooleanFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;
import org.jivesoftware.smackx.xdata.JidMultiFormField;
import org.jivesoftware.smackx.xdata.JidSingleFormField;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class DataFormProvider extends ExtensionElementProvider<DataForm> {
    public static final DataFormProvider INSTANCE = new DataFormProvider();
    private static final Logger LOGGER = Logger.getLogger(DataFormProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.xdata.provider.DataFormProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(2:21|22)|23|25|26|27|28|29|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                org.jivesoftware.smackx.xdata.FormField$Type[] r0 = org.jivesoftware.smackx.xdata.FormField.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = r0
                r1 = 1
                org.jivesoftware.smackx.xdata.FormField$Type r2 = org.jivesoftware.smackx.xdata.FormField.Type.bool     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.fixed     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.hidden     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.jid_multi     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.jid_single     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.list_multi     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.list_single     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.text_multi     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r4 = 8
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.text_private     // Catch:{ NoSuchFieldError -> 0x006c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r4 = 9
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r2 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.text_single     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r4 = 10
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent[] r2 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = r2
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r3 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r2 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent     // Catch:{ NoSuchFieldError -> 0x0093 }
                org.jivesoftware.smack.xml.XmlPullParser$TagEvent r3 = org.jivesoftware.smack.xml.XmlPullParser.TagEvent.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r2
                org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r1 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x00ae }
                org.jivesoftware.smack.xml.XmlPullParser$Event r2 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.provider.DataFormProvider.AnonymousClass1.<clinit>():void");
        }
    }

    private static void addOptionsToBuilder(Collection<FormField.Option> collection, FormFieldWithOptions.Builder<?> builder) {
        for (FormField.Option addOption : collection) {
            builder.addOption(addOption);
        }
    }

    private static void ensureAtMostSingleValue(FormField.Type type, List<FormField.Value> list) throws SmackParsingException {
        if (list.size() > 1) {
            throw new SmackParsingException(type + " fields can have at most one value, this one had " + list.size());
        }
    }

    private static FormField.Builder<?, ?> parseBooleanFormField(String str, List<FormField.Value> list) throws SmackParsingException {
        BooleanFormField.Builder booleanBuilder = FormField.booleanBuilder(str);
        ensureAtMostSingleValue(booleanBuilder.getType(), list);
        if (list.size() == 1) {
            booleanBuilder.setValue(list.get(0));
        }
        return booleanBuilder;
    }

    private static FormField parseField(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str) throws XmlPullParserException, IOException, SmackParsingException {
        return parseField(xmlPullParser, xmlEnvironment, str, (DataForm.ReportedData) null);
    }

    private static DataForm.Item parseItem(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str, DataForm.ReportedData reportedData) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser, XmlEnvironment.from(xmlPullParser, xmlEnvironment), str, reportedData));
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new DataForm.Item(arrayList);
            }
        }
    }

    private static AbstractMultiFormField.Builder<?, ?> parseMultiKindFormField(AbstractMultiFormField.Builder<?, ?> builder, List<FormField.Value> list) {
        for (FormField.Value value : list) {
            builder.addValue(value.getValue());
        }
        return builder;
    }

    public static FormField.Option parseOption(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("", "label");
        FormField.Option option = null;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("value")) {
                    option = new FormField.Option(attributeValue, xmlPullParser.nextText());
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return option;
            }
        }
    }

    private static DataForm.ReportedData parseReported(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser, XmlEnvironment.from(xmlPullParser, xmlEnvironment), str));
                }
            } else if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                return new DataForm.ReportedData(arrayList);
            }
        }
    }

    private static AbstractSingleStringValueFormField.Builder<?, ?> parseSingleKindFormField(AbstractSingleStringValueFormField.Builder<?, ?> builder, List<FormField.Value> list) throws SmackParsingException {
        ensureAtMostSingleValue(builder.getType(), list);
        if (list.size() == 1) {
            builder.setValue((CharSequence) list.get(0).getValue().toString());
        }
        return builder;
    }

    public static FormField.Value parseValue(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return new FormField.Value(xmlPullParser.nextText());
    }

    private static FormField parseField(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str, DataForm.ReportedData reportedData) throws XmlPullParserException, IOException, SmackParsingException {
        AbstractSingleStringValueFormField.Builder<?, ?> builder;
        FormField field;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String str2 = str;
        DataForm.ReportedData reportedData2 = reportedData;
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser2.getAttributeValue("var");
        String attributeValue2 = xmlPullParser2.getAttributeValue("", "label");
        String attributeValue3 = xmlPullParser2.getAttributeValue("type");
        FormField.Type fromString = attributeValue3 != null ? FormField.Type.fromString(attributeValue3) : null;
        ArrayList<FormField.Value> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z10 = false;
        while (true) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i10 != 1) {
                if (i10 == 2 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            } else {
                QName qName = xmlPullParser.getQName();
                if (qName.equals(FormField.Value.QNAME)) {
                    arrayList.add(parseValue(xmlPullParser));
                } else if (qName.equals(FormField.Option.QNAME)) {
                    arrayList2.add(parseOption(xmlPullParser));
                } else if (qName.equals(FormField.Required.QNAME)) {
                    z10 = true;
                } else {
                    FormFieldChildElementProvider<?> formFieldChildElementProvider = FormFieldChildElementProviderManager.getFormFieldChildElementProvider(qName);
                    if (formFieldChildElementProvider == null) {
                        LOGGER.warning("Unknown form field child element " + qName + " ignored");
                    } else {
                        arrayList3.add((FormFieldChildElement) formFieldChildElementProvider.parse(xmlPullParser2, XmlEnvironment.from(xmlPullParser, xmlEnvironment)));
                    }
                }
            }
        }
        if (!(fromString != null || reportedData2 == null || (field = reportedData2.getField(attributeValue)) == null)) {
            fromString = field.getType();
        }
        if (fromString == null) {
            if (attributeValue.equals(FormField.FORM_TYPE)) {
                fromString = FormField.Type.hidden;
            } else {
                fromString = FormFieldRegistry.lookup(str2, attributeValue);
                if (fromString == null) {
                    LOGGER.warning("The Field '" + attributeValue + "' from FORM_TYPE '" + str2 + "' is not registered. Field type is unknown, assuming text-single.");
                    fromString = FormField.Type.text_single;
                }
            }
        }
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[fromString.ordinal()]) {
            case 1:
                builder = parseBooleanFormField(attributeValue, arrayList);
                break;
            case 2:
                builder = parseSingleKindFormField(FormField.fixedBuilder(attributeValue), arrayList);
                break;
            case 3:
                builder = parseSingleKindFormField(FormField.hiddenBuilder(attributeValue), arrayList);
                break;
            case 4:
                JidMultiFormField.Builder jidMultiBuilder = FormField.jidMultiBuilder(attributeValue);
                for (FormField.Value addValue : arrayList) {
                    jidMultiBuilder.addValue(addValue);
                }
                builder = jidMultiBuilder;
                break;
            case 5:
                ensureAtMostSingleValue(fromString, arrayList);
                JidSingleFormField.Builder jidSingleBuilder = FormField.jidSingleBuilder(attributeValue);
                builder = jidSingleBuilder;
                if (!arrayList.isEmpty()) {
                    jidSingleBuilder.setValue((FormField.Value) arrayList.get(0));
                    builder = jidSingleBuilder;
                    break;
                }
                break;
            case 6:
                ListMultiFormField.Builder listMultiBuilder = FormField.listMultiBuilder(attributeValue);
                addOptionsToBuilder(arrayList2, listMultiBuilder);
                builder = parseMultiKindFormField(listMultiBuilder, arrayList);
                break;
            case 7:
                ListSingleFormField.Builder listSingleBuilder = FormField.listSingleBuilder(attributeValue);
                addOptionsToBuilder(arrayList2, listSingleBuilder);
                builder = parseSingleKindFormField(listSingleBuilder, arrayList);
                break;
            case 8:
                builder = parseMultiKindFormField(FormField.textMultiBuilder(attributeValue), arrayList);
                break;
            case 9:
                builder = parseSingleKindFormField(FormField.textPrivateBuilder(attributeValue), arrayList);
                break;
            case 10:
                builder = parseSingleKindFormField(FormField.textSingleBuilder(attributeValue), arrayList);
                break;
            default:
                throw new AssertionError("Unknown type " + fromString);
        }
        int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[fromString.ordinal()];
        if (i11 == 6 || i11 == 7 || arrayList2.isEmpty()) {
            if (attributeValue2 != null) {
                builder.setLabel(attributeValue2);
            }
            builder.setRequired(z10);
            builder.addFormFieldChildElements(arrayList3);
            return builder.build();
        }
        throw new SmackParsingException("Form fields of type " + fromString + " must not have options. This one had " + arrayList2.size());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r3.equals(org.jivesoftware.smackx.xdatalayout.packet.DataLayout.ELEMENT) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0012, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.xdata.packet.DataForm parse(org.jivesoftware.smack.xml.XmlPullParser r11, int r12, org.jivesoftware.smack.packet.XmlEnvironment r13) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            r10 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "type"
            java.lang.String r0 = r11.getAttributeValue(r0, r1)
            org.jivesoftware.smackx.xdata.packet.DataForm$Type r0 = org.jivesoftware.smackx.xdata.packet.DataForm.Type.fromString(r0)
            org.jivesoftware.smackx.xdata.packet.DataForm$Builder r0 = org.jivesoftware.smackx.xdata.packet.DataForm.builder(r0)
            r1 = 0
            r2 = r1
        L_0x0012:
            org.jivesoftware.smack.xml.XmlPullParser$Event r3 = r11.next()
            int[] r4 = org.jivesoftware.smackx.xdata.provider.DataFormProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 2
            r5 = 1
            if (r3 == r5) goto L_0x0030
            if (r3 == r4) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            int r3 = r11.getDepth()
            if (r3 != r12) goto L_0x0012
            org.jivesoftware.smackx.xdata.packet.DataForm r11 = r0.build()
            return r11
        L_0x0030:
            java.lang.String r3 = r11.getName()
            java.lang.String r6 = r11.getNamespace()
            org.jivesoftware.smack.packet.XmlEnvironment r7 = org.jivesoftware.smack.packet.XmlEnvironment.from(r11, r13)
            r3.hashCode()
            r8 = -1
            int r9 = r3.hashCode()
            switch(r9) {
                case -427039533: goto L_0x0089;
                case 3242771: goto L_0x007e;
                case 3433103: goto L_0x0075;
                case 97427706: goto L_0x006a;
                case 107944136: goto L_0x005f;
                case 110371416: goto L_0x0054;
                case 757376421: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            r4 = r8
            goto L_0x0093
        L_0x0049:
            java.lang.String r4 = "instructions"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0052
            goto L_0x0047
        L_0x0052:
            r4 = 6
            goto L_0x0093
        L_0x0054:
            java.lang.String r4 = "title"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x005d
            goto L_0x0047
        L_0x005d:
            r4 = 5
            goto L_0x0093
        L_0x005f:
            java.lang.String r4 = "query"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0068
            goto L_0x0047
        L_0x0068:
            r4 = 4
            goto L_0x0093
        L_0x006a:
            java.lang.String r4 = "field"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0073
            goto L_0x0047
        L_0x0073:
            r4 = 3
            goto L_0x0093
        L_0x0075:
            java.lang.String r5 = "page"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0093
            goto L_0x0047
        L_0x007e:
            java.lang.String r4 = "item"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0087
            goto L_0x0047
        L_0x0087:
            r4 = r5
            goto L_0x0093
        L_0x0089:
            java.lang.String r4 = "reported"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0092
            goto L_0x0047
        L_0x0092:
            r4 = 0
        L_0x0093:
            switch(r4) {
                case 0: goto L_0x00f5;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00db;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00aa;
                case 5: goto L_0x00a1;
                case 6: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x0012
        L_0x0098:
            java.lang.String r3 = r11.nextText()
            r0.addInstruction(r3)
            goto L_0x0012
        L_0x00a1:
            java.lang.String r3 = r11.nextText()
            r0.setTitle(r3)
            goto L_0x0012
        L_0x00aa:
            java.lang.String r3 = "jabber:iq:roster"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0012
            org.jivesoftware.smack.roster.provider.RosterPacketProvider r3 = org.jivesoftware.smack.roster.provider.RosterPacketProvider.INSTANCE
            org.jivesoftware.smack.packet.IQ r3 = r3.parse(r11)
            r0.addExtensionElement(r3)
            goto L_0x0012
        L_0x00bd:
            org.jivesoftware.smackx.xdata.FormField r3 = parseField(r11, r7, r1)
            org.jivesoftware.smackx.xdata.TextSingleFormField r4 = r3.asHiddenFormTypeFieldIfPossible()
            if (r4 == 0) goto L_0x00d6
            if (r1 != 0) goto L_0x00ce
            java.lang.String r1 = r4.getValue()
            goto L_0x00d6
        L_0x00ce:
            org.jivesoftware.smack.parsing.SmackParsingException r11 = new org.jivesoftware.smack.parsing.SmackParsingException
            java.lang.String r12 = "Multiple hidden form type fields"
            r11.<init>((java.lang.String) r12)
            throw r11
        L_0x00d6:
            r0.addField(r3)
            goto L_0x0012
        L_0x00db:
            java.lang.String r3 = "http://jabber.org/protocol/xdata-layout"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0012
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout r3 = org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.parse(r11)
            r0.addExtensionElement(r3)
            goto L_0x0012
        L_0x00ec:
            org.jivesoftware.smackx.xdata.packet.DataForm$Item r3 = parseItem(r11, r7, r1, r2)
            r0.addItem(r3)
            goto L_0x0012
        L_0x00f5:
            if (r2 != 0) goto L_0x0100
            org.jivesoftware.smackx.xdata.packet.DataForm$ReportedData r2 = parseReported(r11, r7, r1)
            r0.setReportedData(r2)
            goto L_0x0012
        L_0x0100:
            org.jivesoftware.smack.parsing.SmackParsingException r11 = new org.jivesoftware.smack.parsing.SmackParsingException
            java.lang.String r12 = "Data form with multiple <reported/> elements"
            r11.<init>((java.lang.String) r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.provider.DataFormProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.xdata.packet.DataForm");
    }
}
