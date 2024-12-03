package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;

public class BooleanFormField extends SingleValueFormField {
    /* access modifiers changed from: private */
    public final Boolean value;

    public static final class Builder extends SingleValueFormField.Builder<BooleanFormField, Builder> {
        /* access modifiers changed from: private */
        public Boolean value;

        @Deprecated
        public Builder addValue(CharSequence charSequence) {
            return setValue(new FormField.Value(charSequence));
        }

        public Builder getThis() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            super.resetInternal();
            this.value = null;
        }

        public Builder setValue(CharSequence charSequence) {
            return setValue(new FormField.Value(charSequence));
        }

        private Builder(BooleanFormField booleanFormField) {
            super(booleanFormField);
            this.value = booleanFormField.value;
        }

        public BooleanFormField build() {
            return new BooleanFormField(this);
        }

        public Builder setValue(FormField.Value value2) {
            this.value = Boolean.valueOf(ParserUtils.parseXmlBoolean(value2.getValue().toString()));
            this.rawValue = value2;
            return getThis();
        }

        Builder(String str) {
            super(str, FormField.Type.bool);
        }

        public Builder setValue(boolean z10) {
            this.rawValue = new FormField.Value(Boolean.toString(z10));
            this.value = Boolean.valueOf(z10);
            return this;
        }
    }

    protected BooleanFormField(Builder builder) {
        super(builder);
        this.value = builder.value;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public boolean getValueAsBoolean() {
        Boolean bool = this.value;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public Boolean getValueAsBooleanOrNull() {
        return this.value;
    }

    public String getValue() {
        Boolean bool = this.value;
        if (bool == null) {
            return null;
        }
        return bool.toString();
    }
}
