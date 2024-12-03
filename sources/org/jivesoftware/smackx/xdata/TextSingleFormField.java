package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;

public class TextSingleFormField extends AbstractSingleStringValueFormField {

    public static final class Builder extends AbstractSingleStringValueFormField.Builder<TextSingleFormField, Builder> {
        public Builder getThis() {
            return this;
        }

        private Builder(TextSingleFormField textSingleFormField) {
            super(textSingleFormField);
        }

        public TextSingleFormField build() {
            return new TextSingleFormField(this);
        }

        Builder(String str, FormField.Type type) {
            super(str, type);
        }
    }

    protected TextSingleFormField(Builder builder) {
        super(builder);
    }

    public Builder asBuilder() {
        return new Builder();
    }
}
