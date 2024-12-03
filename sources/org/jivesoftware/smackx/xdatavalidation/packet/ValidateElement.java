package org.jivesoftware.smackx.xdatavalidation.packet;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdatavalidation.ValidationConsistencyException;

public abstract class ValidateElement implements FormFieldChildElement {
    public static final String DATATYPE_XS_STRING = "xs:string";
    public static final String ELEMENT = "validate";
    public static final String NAMESPACE = "http://jabber.org/protocol/xdata-validate";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final String datatype;
    private ListRange listRange;

    /* renamed from: org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smackx.xdata.FormField$Type[] r0 = org.jivesoftware.smackx.xdata.FormField.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = r0
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.hidden     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.jid_multi     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.jid_single     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.list_multi     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.text_multi     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.AnonymousClass1.<clinit>():void");
        }
    }

    public static class BasicValidateElement extends ValidateElement {
        public static final String METHOD = "basic";

        public BasicValidateElement(String str) {
            super(str, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement(METHOD);
        }

        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkListRangeConsistency(builder);
            if (builder.getType() != null) {
                int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()];
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", new Object[]{builder.getType(), METHOD}));
                }
            }
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return ValidateElement.super.toXML(xmlEnvironment);
        }
    }

    public static class ListRange implements FullyQualifiedElement {
        public static final String ELEMENT = "list-range";
        private final UInt32 max;
        private final UInt32 min;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ListRange(Long l10, Long l11) {
            this(l10 != null ? UInt32.from(l10.longValue()) : null, l11 != null ? UInt32.from(l11.longValue()) : null);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public UInt32 getMax() {
            return this.max;
        }

        public UInt32 getMin() {
            return this.min;
        }

        public String getNamespace() {
            return ValidateElement.NAMESPACE;
        }

        public ListRange(UInt32 uInt32, UInt32 uInt322) {
            if (uInt322 == null && uInt32 == null) {
                throw new IllegalArgumentException("Either min or max must be given");
            }
            this.min = uInt32;
            this.max = uInt322;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttributeCs("min", getMin());
            xmlStringBuilder.optAttributeCs("max", getMax());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class OpenValidateElement extends ValidateElement {
        public static final String METHOD = "open";

        public OpenValidateElement(String str) {
            super(str, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement("open");
        }

        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkListRangeConsistency(builder);
            if (builder.getType() != null && AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()] == 1) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", new Object[]{builder.getType(), "open"}));
            }
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return ValidateElement.super.toXML(xmlEnvironment);
        }
    }

    public static class RangeValidateElement extends ValidateElement {
        public static final String METHOD = "range";
        private final String max;
        private final String min;

        public RangeValidateElement(String str, String str2, String str3) {
            super(str, (AnonymousClass1) null);
            this.min = str2;
            this.max = str3;
        }

        /* access modifiers changed from: protected */
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.halfOpenElement("range");
            xmlStringBuilder.optAttribute("min", getMin());
            xmlStringBuilder.optAttribute("max", getMax());
            xmlStringBuilder.closeEmptyElement();
        }

        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkNonMultiConsistency(builder, "range");
            if (getDatatype().equals(ValidateElement.DATATYPE_XS_STRING)) {
                throw new ValidationConsistencyException(String.format("Field data type '%1$s' is not consistent with validation method '%2$s'.", new Object[]{getDatatype(), "range"}));
            }
        }

        public String getMax() {
            return this.max;
        }

        public String getMin() {
            return this.min;
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return ValidateElement.super.toXML(xmlEnvironment);
        }

        public void validate(FormField formField) {
            AbstractSingleStringValueFormField abstractSingleStringValueFormField = (AbstractSingleStringValueFormField) formField.ifPossibleAs(AbstractSingleStringValueFormField.class);
            if (abstractSingleStringValueFormField != null) {
                String value = abstractSingleStringValueFormField.getValue();
                String datatype = getDatatype();
                datatype.hashCode();
                if (datatype.equals("xs:int") || datatype.equals("xs:integer")) {
                    BigInteger bigInteger = new BigInteger(value);
                    String min2 = getMin();
                    if (min2 == null || bigInteger.compareTo(new BigInteger(min2)) >= 0) {
                        String max2 = getMax();
                        if (max2 != null && bigInteger.compareTo(new BigInteger(max2)) > 0) {
                            throw new IllegalArgumentException("The provided value " + value + " is higher than the allowed maximum of " + max2);
                        }
                        return;
                    }
                    throw new IllegalArgumentException("The provided value " + value + " is lower than the allowed minimum of " + min2);
                }
            }
        }
    }

    public static class RegexValidateElement extends ValidateElement {
        public static final String METHOD = "regex";
        private final String regex;

        public RegexValidateElement(String str, String str2) {
            super(str, (AnonymousClass1) null);
            this.regex = str2;
        }

        /* access modifiers changed from: protected */
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.element(METHOD, getRegex());
        }

        public void checkConsistency(FormField.Builder<?, ?> builder) {
            checkNonMultiConsistency(builder, METHOD);
        }

        public String getRegex() {
            return this.regex;
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return ValidateElement.super.toXML(xmlEnvironment);
        }
    }

    /* synthetic */ ValidateElement(String str, AnonymousClass1 r22) {
        this(str);
    }

    public static ValidateElement from(FormField formField) {
        return (ValidateElement) formField.getFormFieldChildElement(QNAME);
    }

    /* access modifiers changed from: protected */
    public abstract void appendXML(XmlStringBuilder xmlStringBuilder);

    public abstract void checkConsistency(FormField.Builder<?, ?> builder);

    /* access modifiers changed from: protected */
    public void checkListRangeConsistency(FormField.Builder<?, ?> builder) {
        ListRange listRange2 = getListRange();
        if (listRange2 != null) {
            UInt32 max = listRange2.getMax();
            UInt32 min = listRange2.getMin();
            if ((max != null || min != null) && builder.getType() != FormField.Type.list_multi) {
                throw new ValidationConsistencyException("Field type is not of type 'list-multi' while a 'list-range' is defined.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkNonMultiConsistency(FormField.Builder<?, ?> builder, String str) {
        checkListRangeConsistency(builder);
        if (builder.getType() != null) {
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[builder.getType().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 4 || i10 == 5) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", new Object[]{builder.getType(), str}));
            }
        }
    }

    public String getDatatype() {
        String str = this.datatype;
        return str != null ? str : DATATYPE_XS_STRING;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public ListRange getListRange() {
        return this.listRange;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public QName getQName() {
        return QNAME;
    }

    public final boolean mustBeOnlyOfHisKind() {
        return true;
    }

    public void setListRange(ListRange listRange2) {
        this.listRange = listRange2;
    }

    private ValidateElement(String str) {
        this.datatype = !StringUtils.isNotEmpty((CharSequence) str) ? null : str;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute("datatype", this.datatype);
        xmlStringBuilder.rightAngleBracket();
        appendXML(xmlStringBuilder);
        xmlStringBuilder.optAppend((Element) getListRange());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
