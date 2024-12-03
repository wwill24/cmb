package org.jivesoftware.smackx.xdata;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.BooleanFormField;
import org.jivesoftware.smackx.xdata.JidMultiFormField;
import org.jivesoftware.smackx.xdata.JidSingleFormField;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.TextMultiFormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jxmpp.util.XmppDateTime;

public abstract class FormField implements FullyQualifiedElement {
    public static final String ELEMENT = "field";
    public static final String FORM_TYPE = "FORM_TYPE";
    public static final String NAMESPACE = "jabber:x:data";
    public static final QName QNAME = new QName("jabber:x:data", ELEMENT);
    private final String description;
    protected transient List<FullyQualifiedElement> extraXmlChildElements;
    /* access modifiers changed from: private */
    public final String fieldName;
    /* access modifiers changed from: private */
    public final List<FormFieldChildElement> formFieldChildElements;
    private final MultiMap<QName, FormFieldChildElement> formFieldChildElementsMap;
    /* access modifiers changed from: private */
    public final String label;
    private transient List<CharSequence> rawValueCharSequences;
    private final boolean required;
    /* access modifiers changed from: private */
    public final Type type;

    /* renamed from: org.jivesoftware.smackx.xdata.FormField$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[Type.bool.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static abstract class Builder<F extends FormField, B extends Builder<?, ?>> {
        private boolean disallowFurtherFormFieldChildElements;
        private boolean disallowType;
        /* access modifiers changed from: private */
        public final String fieldName;
        /* access modifiers changed from: private */
        public List<FormFieldChildElement> formFieldChildElements;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public final Type type;

        protected Builder(String str, Type type2) {
            if (!StringUtils.isNullOrEmpty((CharSequence) str) || type2 == Type.fixed) {
                this.fieldName = str;
                this.type = type2;
                return;
            }
            throw new IllegalArgumentException("Fields of type " + type2 + " must have a field name set");
        }

        private void ensureThatFormFieldChildElementsIsSet() {
            if (this.formFieldChildElements == null) {
                this.formFieldChildElements = new ArrayList(4);
            }
        }

        private <E extends FormFieldChildElement> void setOnlyElement(E e10) {
            Class<?> cls = e10.getClass();
            ensureThatFormFieldChildElementsIsSet();
            for (int i10 = 0; i10 < this.formFieldChildElements.size(); i10++) {
                if (this.formFieldChildElements.get(i10).getClass().equals(cls)) {
                    this.formFieldChildElements.set(i10, e10);
                    return;
                }
            }
            addFormFieldChildElement(e10);
        }

        public B addFormFieldChildElement(FormFieldChildElement formFieldChildElement) {
            boolean z10;
            if (this.disallowFurtherFormFieldChildElements) {
                throw new IllegalArgumentException();
            } else if (!formFieldChildElement.requiresNoTypeSet() || this.type == null) {
                ensureThatFormFieldChildElementsIsSet();
                if (this.formFieldChildElements.isEmpty() || !formFieldChildElement.isExclusiveElement()) {
                    if (this.disallowType || formFieldChildElement.requiresNoTypeSet()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.disallowType = z10;
                    this.disallowFurtherFormFieldChildElements = formFieldChildElement.isExclusiveElement();
                    this.formFieldChildElements.add(formFieldChildElement);
                    for (FormFieldChildElement checkConsistency : this.formFieldChildElements) {
                        try {
                            checkConsistency.checkConsistency(this);
                        } catch (IllegalArgumentException e10) {
                            this.formFieldChildElements.remove(formFieldChildElement);
                            throw e10;
                        }
                    }
                    return getThis();
                }
                throw new IllegalArgumentException("Elements of type " + formFieldChildElement.getClass() + " must be the only child elements of a form field.");
            } else {
                throw new IllegalArgumentException("Elements of type " + formFieldChildElement.getClass() + " can only be added to form fields where no type is set");
            }
        }

        public B addFormFieldChildElements(Collection<? extends FormFieldChildElement> collection) {
            for (FormFieldChildElement addFormFieldChildElement : collection) {
                addFormFieldChildElement(addFormFieldChildElement);
            }
            return getThis();
        }

        public abstract F build();

        public abstract B getThis();

        public Type getType() {
            return this.type;
        }

        public B reset() {
            resetInternal();
            List<FormFieldChildElement> list = this.formFieldChildElements;
            if (list == null) {
                return getThis();
            }
            Iterator<FormFieldChildElement> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Value) {
                    it.remove();
                }
            }
            this.disallowFurtherFormFieldChildElements = false;
            this.disallowType = false;
            return getThis();
        }

        /* access modifiers changed from: protected */
        public abstract void resetInternal();

        public B setDescription(String str) {
            setOnlyElement(new Description(str));
            return getThis();
        }

        public B setLabel(String str) {
            this.label = (String) Objects.requireNonNull(str, "label must not be null");
            return getThis();
        }

        public B setRequired() {
            return setRequired(true);
        }

        public B setRequired(boolean z10) {
            if (z10) {
                setOnlyElement(Required.INSTANCE);
            }
            return getThis();
        }

        protected Builder(FormField formField) {
            this.fieldName = formField.fieldName;
            this.label = formField.label;
            this.type = formField.type;
            this.formFieldChildElements = CollectionUtil.newListWith(formField.formFieldChildElements);
        }
    }

    public static class Description extends StandardFormFieldChildElement {
        public static final String ELEMENT = "desc";
        public static final QName QNAME = new QName("jabber:x:data", "desc");
        private final String description;

        public Description(String str) {
            super((AnonymousClass1) null);
            this.description = str;
        }

        public String getDescription() {
            return this.description;
        }

        public String getElementName() {
            return "desc";
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public QName getQName() {
            return QNAME;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.description);
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static final class Option implements FullyQualifiedElement {
        public static final String ELEMENT = "option";
        public static final QName QNAME = new QName("jabber:x:data", ELEMENT);
        private final HashCode.Cache hashCodeCache;
        private final String label;
        private final Value value;

        public Option(String str) {
            this((String) null, str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, Option option) {
            builder.append(this.value, option.value).append(this.label, option.label);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$hashCode$1(HashCode.Builder builder) {
            builder.append((Object) this.value).append((Object) this.label);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new b(this));
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getLabel() {
            return this.label;
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public QName getQName() {
            return QNAME;
        }

        public Value getValue() {
            return this.value;
        }

        public String getValueString() {
            return this.value.value.toString();
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new a(this));
        }

        public String toString() {
            return getLabel();
        }

        public Option(String str, String str2) {
            this.hashCodeCache = new HashCode.Cache();
            this.label = str;
            this.value = new Value(str2);
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.optAttribute("label", getLabel());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.element("value", getValueString());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }

        public Option(String str, Value value2) {
            this.hashCodeCache = new HashCode.Cache();
            this.label = str;
            this.value = value2;
        }
    }

    public static final class Required extends StandardFormFieldChildElement {
        public static final String ELEMENT = "required";
        public static final Required INSTANCE = new Required();
        public static final QName QNAME = new QName("jabber:x:data", ELEMENT);

        private Required() {
            super((AnonymousClass1) null);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public QName getQName() {
            return QNAME;
        }

        public boolean mustBeOnlyOfHisKind() {
            return true;
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<required/>";
        }
    }

    private static abstract class StandardFormFieldChildElement implements FormFieldChildElement {
        private StandardFormFieldChildElement() {
        }

        /* synthetic */ StandardFormFieldChildElement(AnonymousClass1 r12) {
            this();
        }
    }

    public enum Type {
        bool,
        fixed,
        hidden,
        jid_multi,
        jid_single,
        list_multi,
        list_single,
        text_multi,
        text_private,
        text_single;

        public static Type fromString(String str) {
            if (str == null) {
                return null;
            }
            if (!str.equals("boolean")) {
                return valueOf(str.replace(SignatureVisitor.SUPER, '_'));
            }
            return bool;
        }

        public String toString() {
            if (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[ordinal()] != 1) {
                return name().replace('_', SignatureVisitor.SUPER);
            }
            return "boolean";
        }
    }

    public static class Value implements FullyQualifiedElement {
        public static final String ELEMENT = "value";
        public static final QName QNAME = new QName("jabber:x:data", "value");
        /* access modifiers changed from: private */
        public final CharSequence value;

        public Value(CharSequence charSequence) {
            this.value = charSequence;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, Value value2) {
            builder.append(this.value, value2.value);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new c(this));
        }

        public String getElementName() {
            return "value";
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public QName getQName() {
            return QNAME;
        }

        public CharSequence getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.value);
            return xmlStringBuilder.closeElement((NamedElement) this);
        }
    }

    protected FormField(Builder<?, ?> builder) {
        String access$000 = builder.fieldName;
        this.fieldName = access$000;
        this.label = builder.label;
        Type access$200 = builder.type;
        this.type = access$200;
        if (builder.formFieldChildElements != null) {
            this.formFieldChildElements = Collections.unmodifiableList(builder.formFieldChildElements);
        } else {
            this.formFieldChildElements = Collections.emptyList();
        }
        if (access$000 != null || access$200 == Type.fixed) {
            String str = null;
            boolean z10 = false;
            ArrayList arrayList = new ArrayList(this.formFieldChildElements.size());
            for (FormFieldChildElement next : this.formFieldChildElements) {
                if (next instanceof Description) {
                    str = ((Description) next).getDescription();
                } else if (next instanceof Required) {
                    z10 = true;
                }
            }
            arrayList.trimToSize();
            this.description = str;
            this.required = z10;
            this.formFieldChildElementsMap = createChildElementsMap();
            return;
        }
        throw new IllegalArgumentException("The variable can only be null if the form is of type fixed");
    }

    public static BooleanFormField.Builder booleanBuilder(String str) {
        return new BooleanFormField.Builder(str);
    }

    public static TextSingleFormField buildHiddenFormType(String str) {
        return ((TextSingleFormField.Builder) hiddenBuilder(FORM_TYPE).setValue((CharSequence) str)).build();
    }

    public static TextSingleFormField.Builder builder(String str) {
        return textSingleBuilder(str);
    }

    private MultiMap<QName, FormFieldChildElement> createChildElementsMap() {
        MultiMap multiMap = new MultiMap(this.formFieldChildElements.size());
        for (FormFieldChildElement next : this.formFieldChildElements) {
            multiMap.put(next.getQName(), next);
        }
        return multiMap.asUnmodifiableMultiMap();
    }

    public static TextSingleFormField.Builder fixedBuilder() {
        return fixedBuilder((String) null);
    }

    public static TextSingleFormField.Builder hiddenBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.hidden);
    }

    public static JidMultiFormField.Builder jidMultiBuilder(String str) {
        return new JidMultiFormField.Builder(str);
    }

    public static JidSingleFormField.Builder jidSingleBuilder(String str) {
        return new JidSingleFormField.Builder(str);
    }

    public static ListMultiFormField.Builder listMultiBuilder(String str) {
        return new ListMultiFormField.Builder(str);
    }

    public static ListSingleFormField.Builder listSingleBuilder(String str) {
        return new ListSingleFormField.Builder(str);
    }

    public static TextMultiFormField.Builder textMultiBuilder(String str) {
        return new TextMultiFormField.Builder(str);
    }

    public static TextSingleFormField.Builder textPrivateBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.text_private);
    }

    public static TextSingleFormField.Builder textSingleBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.text_single);
    }

    public TextSingleFormField asHiddenFormTypeFieldIfPossible() {
        TextSingleFormField textSingleFormField = (TextSingleFormField) ifPossibleAs(TextSingleFormField.class);
        if (textSingleFormField != null && getType() == Type.hidden && getFieldName().equals(FORM_TYPE)) {
            return textSingleFormField;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FormField)) {
            return false;
        }
        return toXML().toString().equals(((FormField) obj).toXML().toString());
    }

    public String getDescription() {
        return this.description;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getFirstValue() {
        List<? extends CharSequence> values = getValues();
        if (values.isEmpty()) {
            return null;
        }
        return ((CharSequence) values.get(0)).toString();
    }

    public Date getFirstValueAsDate() throws ParseException {
        String firstValue = getFirstValue();
        if (firstValue == null) {
            return null;
        }
        return XmppDateTime.m(firstValue);
    }

    public FormFieldChildElement getFormFieldChildElement(QName qName) {
        return this.formFieldChildElementsMap.getFirst(qName);
    }

    public List<FormFieldChildElement> getFormFieldChildElements(QName qName) {
        return this.formFieldChildElementsMap.getAll(qName);
    }

    public String getLabel() {
        return this.label;
    }

    public String getNamespace() {
        return "jabber:x:data";
    }

    public QName getQName() {
        return QNAME;
    }

    public final List<CharSequence> getRawValueCharSequences() {
        if (this.rawValueCharSequences == null) {
            List<Value> rawValues = getRawValues();
            this.rawValueCharSequences = new ArrayList(rawValues.size());
            for (Value access$400 : rawValues) {
                this.rawValueCharSequences.add(access$400.value);
            }
        }
        return this.rawValueCharSequences;
    }

    public abstract List<Value> getRawValues();

    public Type getType() {
        Type type2 = this.type;
        if (type2 == null) {
            return Type.text_single;
        }
        return type2;
    }

    public List<? extends CharSequence> getValues() {
        return getRawValueCharSequences();
    }

    public List<String> getValuesAsString() {
        List<? extends CharSequence> values = getValues();
        ArrayList arrayList = new ArrayList(values.size());
        for (CharSequence charSequence : values) {
            arrayList.add(charSequence.toString());
        }
        return arrayList;
    }

    @Deprecated
    public String getVariable() {
        return getFieldName();
    }

    public boolean hasValueSet() {
        return !getValues().isEmpty();
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }

    public <F extends FormField> F ifPossibleAs(Class<F> cls) {
        if (cls.isInstance(this)) {
            return (FormField) cls.cast(this);
        }
        return null;
    }

    public <F extends FormField> F ifPossibleAsOrThrow(Class<F> cls) {
        F ifPossibleAs = ifPossibleAs(cls);
        if (ifPossibleAs != null) {
            return ifPossibleAs;
        }
        throw new IllegalArgumentException();
    }

    public boolean isRequired() {
        return this.required;
    }

    /* access modifiers changed from: protected */
    public void populateExtraXmlChildElements() {
        List<Value> rawValues = getRawValues();
        ArrayList arrayList = new ArrayList(rawValues.size());
        this.extraXmlChildElements = arrayList;
        arrayList.addAll(rawValues);
    }

    public static TextSingleFormField.Builder fixedBuilder(String str) {
        return new TextSingleFormField.Builder(str, Type.fixed);
    }

    public List<FormFieldChildElement> getFormFieldChildElements() {
        return this.formFieldChildElements;
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return toXML(xmlEnvironment, true);
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment, boolean z10) {
        List<FullyQualifiedElement> list;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute("label", getLabel());
        xmlStringBuilder.optAttribute("var", getFieldName());
        if (z10) {
            xmlStringBuilder.attribute("type", getType(), Type.text_single);
        }
        if (this.extraXmlChildElements == null) {
            populateExtraXmlChildElements();
        }
        if (!this.formFieldChildElements.isEmpty() || ((list = this.extraXmlChildElements) != null && !list.isEmpty())) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optAppend((Collection<? extends Element>) this.extraXmlChildElements);
            xmlStringBuilder.append((Collection<? extends Element>) this.formFieldChildElements);
            xmlStringBuilder.closeElement((NamedElement) this);
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        return xmlStringBuilder;
    }
}
