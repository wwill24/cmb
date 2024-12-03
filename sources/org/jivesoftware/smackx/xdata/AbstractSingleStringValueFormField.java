package org.jivesoftware.smackx.xdata;

import java.net.URL;
import java.util.Date;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;
import org.jxmpp.util.XmppDateTime;

public class AbstractSingleStringValueFormField extends SingleValueFormField {
    private final String value;

    protected AbstractSingleStringValueFormField(Builder<?, ?> builder) {
        super(builder);
        this.value = builder.value;
    }

    public final Integer getValueAsInt() {
        String str = this.value;
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str);
    }

    public static abstract class Builder<F extends SingleValueFormField, B extends SingleValueFormField.Builder<F, B>> extends SingleValueFormField.Builder<F, B> {
        /* access modifiers changed from: private */
        public String value;

        protected Builder(AbstractSingleStringValueFormField abstractSingleStringValueFormField) {
            super(abstractSingleStringValueFormField);
            this.value = abstractSingleStringValueFormField.getValue();
        }

        @Deprecated
        public B addValue(CharSequence charSequence) {
            return setValue(charSequence);
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            this.value = null;
        }

        public B setValue(FormField.Value value2) {
            this.value = value2.getValue().toString();
            this.rawValue = value2;
            return (SingleValueFormField.Builder) getThis();
        }

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }

        public B setValue(CharSequence charSequence) {
            this.value = charSequence.toString();
            this.rawValue = new FormField.Value(this.value);
            return (SingleValueFormField.Builder) getThis();
        }

        public B setValue(Enum<?> enumR) {
            return setValue((CharSequence) enumR.toString());
        }

        public B setValue(int i10) {
            return setValue((CharSequence) Integer.toString(i10));
        }

        public B setValue(URL url) {
            return setValue((CharSequence) url.toString());
        }

        public B setValue(Date date) {
            return setValue((CharSequence) XmppDateTime.i(date));
        }
    }

    public final String getValue() {
        return this.value;
    }
}
