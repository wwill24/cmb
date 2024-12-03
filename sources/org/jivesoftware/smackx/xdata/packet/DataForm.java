package org.jivesoftware.smackx.xdata.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;

public final class DataForm implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:data";
    public static final QName QNAME = new QName("jabber:x:data", "x");
    private final List<Element> extensionElements;
    private final List<FormField> fields;
    /* access modifiers changed from: private */
    public final Map<String, FormField> fieldsMap;
    private final List<String> instructions;
    private final List<Item> items;
    private final ReportedData reportedData;
    private final String title;
    private final Type type;

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<Element> extensionElements;
        /* access modifiers changed from: private */
        public List<FormField> fields;
        /* access modifiers changed from: private */
        public Map<String, FormField> fieldsMap;
        /* access modifiers changed from: private */
        public List<String> instructions;
        /* access modifiers changed from: private */
        public List<Item> items;
        /* access modifiers changed from: private */
        public ReportedData reportedData;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public Type type;

        /* access modifiers changed from: private */
        public void orderFields() {
            Iterator<FormField> it = this.fields.iterator();
            if (it.hasNext() && it.next().asHiddenFormTypeFieldIfPossible() == null) {
                while (it.hasNext()) {
                    TextSingleFormField asHiddenFormTypeFieldIfPossible = it.next().asHiddenFormTypeFieldIfPossible();
                    if (asHiddenFormTypeFieldIfPossible != null) {
                        it.remove();
                        this.fields.add(0, asHiddenFormTypeFieldIfPossible);
                        return;
                    }
                }
            }
        }

        public Builder addExtensionElement(Element element) {
            if (this.extensionElements == null) {
                this.extensionElements = new ArrayList();
            }
            this.extensionElements.add(element);
            return this;
        }

        public Builder addField(FormField formField) {
            String fieldName = formField.getFieldName();
            if (fieldName != null) {
                if (!this.fieldsMap.containsKey(fieldName)) {
                    this.fieldsMap.put(fieldName, formField);
                } else {
                    throw new IllegalArgumentException("A field with the name " + fieldName + " already exists");
                }
            }
            this.fields.add(formField);
            return this;
        }

        public Builder addFields(Collection<? extends FormField> collection) {
            for (FormField fieldName : collection) {
                String fieldName2 = fieldName.getFieldName();
                if (this.fieldsMap.containsKey(fieldName2)) {
                    throw new IllegalArgumentException("A field with the name " + fieldName2 + " already exists");
                }
            }
            for (FormField formField : collection) {
                String fieldName3 = formField.getFieldName();
                if (fieldName3 != null) {
                    this.fieldsMap.put(fieldName3, formField);
                }
                this.fields.add(formField);
            }
            return this;
        }

        public Builder addInstruction(String str) {
            if (this.instructions == null) {
                this.instructions = new ArrayList();
            }
            this.instructions.add(str);
            return this;
        }

        public Builder addItem(Item item) {
            if (this.items == null) {
                this.items = new ArrayList();
            }
            this.items.add(item);
            return this;
        }

        public DataForm build() {
            return new DataForm(this);
        }

        public Builder removeField(String str) {
            FormField remove = this.fieldsMap.remove(str);
            if (remove != null) {
                this.fields.remove(remove);
            }
            return this;
        }

        public Builder setFormType(String str) {
            return addField(FormField.buildHiddenFormType(str));
        }

        public Builder setInstructions(String str) {
            return setInstructions(StringUtils.splitLinesPortable(str));
        }

        public Builder setReportedData(ReportedData reportedData2) {
            this.reportedData = reportedData2;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Deprecated
        public Builder setType(Type type2) {
            this.type = (Type) Objects.requireNonNull(type2);
            return this;
        }

        public Builder setInstructions(List<String> list) {
            this.instructions = list;
            return this;
        }

        private Builder() {
            this(Type.submit);
        }

        private Builder(Type type2) {
            this.fields = new ArrayList();
            this.fieldsMap = new HashMap();
            this.type = type2;
        }

        private Builder(DataForm dataForm) {
            this.fields = new ArrayList();
            this.fieldsMap = new HashMap();
            this.type = dataForm.getType();
            this.title = dataForm.getTitle();
            this.instructions = dataForm.getInstructions();
            this.reportedData = dataForm.getReportedData();
            this.items = CollectionUtil.newListWith(dataForm.getItems());
            this.fields = CollectionUtil.newListWith(dataForm.getFields());
            this.fieldsMap = new HashMap(dataForm.fieldsMap);
            this.extensionElements = CollectionUtil.newListWith(dataForm.getExtensionElements());
        }
    }

    public static class Item implements ExtensionElement {
        public static final String ELEMENT = "item";
        public static final QName QNAME = new QName("jabber:x:data", "item");
        private final List<? extends FormField> fields;

        public Item(List<? extends FormField> list) {
            this.fields = Collections.unmodifiableList(list);
        }

        public String getElementName() {
            return "item";
        }

        public List<? extends FormField> getFields() {
            return this.fields;
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Collection<? extends Element>) getFields());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static class ReportedData implements ExtensionElement {
        public static final String ELEMENT = "reported";
        public static final QName QNAME = new QName("jabber:x:data", ELEMENT);
        private Map<String, FormField> fieldMap;
        private final List<? extends FormField> fields;

        public ReportedData(List<? extends FormField> list) {
            this.fields = Collections.unmodifiableList(list);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public FormField getField(String str) {
            if (this.fieldMap == null) {
                this.fieldMap = new HashMap(this.fields.size());
                for (FormField formField : this.fields) {
                    this.fieldMap.put(formField.getFieldName(), formField);
                }
            }
            return this.fieldMap.get(str);
        }

        public List<? extends FormField> getFields() {
            return this.fields;
        }

        public String getNamespace() {
            return "jabber:x:data";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Collection<? extends Element>) getFields());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public enum Type {
        form,
        submit,
        cancel,
        result;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static DataForm from(StanzaView stanzaView) {
        return from(stanzaView, (String) null);
    }

    public static DataForm remove(Collection<DataForm> collection, String str) {
        Iterator<DataForm> it = collection.iterator();
        while (it.hasNext()) {
            DataForm next = it.next();
            if (str.equals(next.getFormType())) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public String getElementName() {
        return "x";
    }

    public List<Element> getExtensionElements() {
        return this.extensionElements;
    }

    public FormField getField(String str) {
        return this.fieldsMap.get(str);
    }

    public List<FormField> getFields() {
        return this.fields;
    }

    public String getFormType() {
        TextSingleFormField hiddenFormTypeField = getHiddenFormTypeField();
        if (hiddenFormTypeField == null) {
            return null;
        }
        return hiddenFormTypeField.getFirstValue();
    }

    public TextSingleFormField getHiddenFormTypeField() {
        FormField field = getField(FormField.FORM_TYPE);
        if (field == null) {
            return null;
        }
        return field.asHiddenFormTypeFieldIfPossible();
    }

    public List<String> getInstructions() {
        return this.instructions;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public String getNamespace() {
        return "jabber:x:data";
    }

    public ReportedData getReportedData() {
        return this.reportedData;
    }

    public String getTitle() {
        return this.title;
    }

    public Type getType() {
        return this.type;
    }

    public boolean hasField(String str) {
        return this.fieldsMap.containsKey(str);
    }

    public boolean hasHiddenFormTypeField() {
        return getHiddenFormTypeField() != null;
    }

    private DataForm(Builder builder) {
        Type access$000 = builder.type;
        this.type = access$000;
        this.title = builder.title;
        this.instructions = CollectionUtil.cloneAndSeal(builder.instructions);
        this.reportedData = builder.reportedData;
        this.items = CollectionUtil.cloneAndSeal(builder.items);
        builder.orderFields();
        this.fields = CollectionUtil.cloneAndSeal(builder.fields);
        this.fieldsMap = CollectionUtil.cloneAndSeal(builder.fieldsMap);
        this.extensionElements = CollectionUtil.cloneAndSeal(builder.extensionElements);
        if (access$000 == Type.form) {
            FormFieldRegistry.register(this);
        }
    }

    public static Builder builder(Type type2) {
        return new Builder(type2);
    }

    public static DataForm from(StanzaView stanzaView, String str) {
        Class<DataForm> cls = DataForm.class;
        if (str == null) {
            return (DataForm) stanzaView.getExtension(cls);
        }
        return from((Collection<DataForm>) stanzaView.getExtensions(cls), str);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("type", (Enum<?>) getType());
        xmlStringBuilder.rightAngleBracket();
        XmlEnvironment xmlEnvironment2 = xmlStringBuilder.getXmlEnvironment();
        xmlStringBuilder.optElement("title", getTitle());
        for (String element : getInstructions()) {
            xmlStringBuilder.element("instructions", element);
        }
        xmlStringBuilder.optElement(getReportedData());
        xmlStringBuilder.append((Collection<? extends Element>) getItems());
        boolean z10 = getType() != Type.submit;
        for (FormField xml : getFields()) {
            xmlStringBuilder.append(xml.toXML(xmlEnvironment2, z10));
        }
        xmlStringBuilder.append((Collection<? extends Element>) getExtensionElements());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public static DataForm from(Collection<DataForm> collection, String str) {
        for (DataForm next : collection) {
            if (str.equals(next.getFormType())) {
                return next;
            }
        }
        return null;
    }
}
