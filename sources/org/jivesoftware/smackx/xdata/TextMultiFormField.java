package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.FormField;

public class TextMultiFormField extends AbstractMultiFormField {

    public static final class Builder extends AbstractMultiFormField.Builder<TextMultiFormField, Builder> {
        public Builder getThis() {
            return this;
        }

        private Builder(TextMultiFormField textMultiFormField) {
            super(textMultiFormField);
        }

        public Builder addValue(CharSequence charSequence) {
            return (Builder) addValues(StringUtils.splitLinesPortable(charSequence.toString()));
        }

        public TextMultiFormField build() {
            return new TextMultiFormField(this);
        }

        Builder(String str) {
            super(str, FormField.Type.text_multi);
        }
    }

    protected TextMultiFormField(Builder builder) {
        super(builder);
    }

    public void addValuesWithNewlines(StringBuilder sb2) {
        for (CharSequence append : getValues()) {
            sb2.append(append);
        }
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public StringBuilder getValueswithNewlines() {
        StringBuilder sb2 = new StringBuilder();
        addValuesWithNewlines(sb2);
        return sb2;
    }
}
