package org.jivesoftware.smackx.iot.data.element;

import org.apache.commons.validator.Var;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class IoTDataField extends IoTDataExtensionElement {
    private final String name;
    private final Type type;
    private String valueString;

    public static class BooleanField extends IoTDataField {
        private final boolean value;

        public BooleanField(String str, boolean z10) {
            super(Type.bool, str);
            this.value = z10;
        }

        public boolean getValue() {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public String getValueInternal() {
            return Boolean.toString(this.value);
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return IoTDataField.super.toXML(xmlEnvironment);
        }
    }

    public static class IntField extends IoTDataField {
        private final int value;

        public IntField(String str, int i10) {
            super(Type.integer, str);
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public String getValueInternal() {
            return Integer.toString(this.value);
        }

        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return IoTDataField.super.toXML(xmlEnvironment);
        }
    }

    enum Type {
        integer(Var.JSTYPE_INT),
        bool("boolean");
        
        /* access modifiers changed from: private */
        public final String stringRepresentation;

        private Type(String str) {
            this.stringRepresentation = str;
        }
    }

    protected IoTDataField(Type type2, String str) {
        this.type = type2;
        this.name = str;
    }

    public final String getElementName() {
        return this.type.stringRepresentation;
    }

    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public abstract String getValueInternal();

    public final String getValueString() {
        if (this.valueString == null) {
            this.valueString = getValueInternal();
        }
        return this.valueString;
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("name", this.name).attribute("value", getValueString());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
