package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.util.XmppDateTime;

public class AbstractMultiFormField extends FormField {
    private final List<FormField.Value> values;

    public static abstract class Builder<F extends AbstractMultiFormField, B extends FormField.Builder<F, B>> extends FormField.Builder<F, B> {
        /* access modifiers changed from: private */
        public List<FormField.Value> values;

        protected Builder(AbstractMultiFormField abstractMultiFormField) {
            super(abstractMultiFormField);
            this.values = CollectionUtil.newListWith(abstractMultiFormField.getRawValues());
        }

        private void ensureValuesAreInitialized() {
            if (this.values == null) {
                this.values = new ArrayList();
            }
        }

        public abstract B addValue(CharSequence charSequence);

        public final B addValue(Date date) {
            return addValueVerbatim((CharSequence) XmppDateTime.i(date));
        }

        public B addValueVerbatim(CharSequence charSequence) {
            return addValueVerbatim(new FormField.Value(charSequence));
        }

        public final B addValues(Collection<? extends CharSequence> collection) {
            ensureValuesAreInitialized();
            for (CharSequence addValueVerbatim : collection) {
                addValueVerbatim(addValueVerbatim);
            }
            return getThis();
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            this.values = null;
        }

        public B addValueVerbatim(FormField.Value value) {
            ensureValuesAreInitialized();
            this.values.add(value);
            return getThis();
        }

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }
    }

    protected AbstractMultiFormField(Builder<?, ?> builder) {
        super(builder);
        this.values = CollectionUtil.cloneAndSeal(builder.values);
    }

    public final List<FormField.Value> getRawValues() {
        return this.values;
    }
}
