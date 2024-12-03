package org.jivesoftware.smackx.xdata;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;

public abstract class SingleValueFormField extends FormField {
    private final FormField.Value rawValue;

    public static abstract class Builder<F extends SingleValueFormField, B extends Builder<F, B>> extends FormField.Builder<F, B> {
        protected FormField.Value rawValue;

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            this.rawValue = null;
        }

        protected Builder(SingleValueFormField singleValueFormField) {
            super(singleValueFormField);
            this.rawValue = singleValueFormField.getRawValue();
        }
    }

    protected SingleValueFormField(Builder<?, ?> builder) {
        super(builder);
        this.rawValue = builder.rawValue;
    }

    public final FormField.Value getRawValue() {
        return this.rawValue;
    }

    public final List<FormField.Value> getRawValues() {
        return CollectionUtil.emptyOrSingletonListFrom(getRawValue());
    }

    public abstract CharSequence getValue();

    public final List<CharSequence> getValues() {
        return CollectionUtil.emptyOrSingletonListFrom(getValue());
    }

    /* access modifiers changed from: protected */
    public void populateExtraXmlChildElements() {
        FormField.Value value = this.rawValue;
        if (value != null) {
            this.extraXmlChildElements = Collections.singletonList(value);
        }
    }
}
