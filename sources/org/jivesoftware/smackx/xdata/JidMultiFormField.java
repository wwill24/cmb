package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public final class JidMultiFormField extends FormField {
    private final List<FormField.Value> rawValues;
    private final List<Jid> values;

    public static final class Builder extends FormField.Builder<JidMultiFormField, Builder> {
        /* access modifiers changed from: private */
        public List<FormField.Value> rawValues;
        /* access modifiers changed from: private */
        public List<Jid> values;

        private void ensureValuesAreInitialized() {
            if (this.values == null) {
                this.values = new ArrayList();
                this.rawValues = new ArrayList();
            }
        }

        public Builder addValue(Jid jid) {
            FormField.Value value = new FormField.Value(jid);
            ensureValuesAreInitialized();
            this.values.add(jid);
            this.rawValues.add(value);
            return getThis();
        }

        public Builder addValues(Collection<? extends Jid> collection) {
            for (Jid addValue : collection) {
                addValue(addValue);
            }
            return this;
        }

        public Builder getThis() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            this.values = null;
            this.rawValues = null;
        }

        private Builder(JidMultiFormField jidMultiFormField) {
            super(jidMultiFormField);
            this.values = CollectionUtil.newListWith(jidMultiFormField.getValues());
        }

        public JidMultiFormField build() {
            return new JidMultiFormField(this);
        }

        Builder(String str) {
            super(str, FormField.Type.jid_multi);
        }

        public Builder addValue(FormField.Value value) throws XmppStringprepException {
            Jid n10 = a.n(value.getValue());
            ensureValuesAreInitialized();
            this.values.add(n10);
            this.rawValues.add(value);
            return this;
        }
    }

    protected JidMultiFormField(Builder builder) {
        super(builder);
        this.values = CollectionUtil.cloneAndSeal(builder.values);
        this.rawValues = CollectionUtil.cloneAndSeal(builder.rawValues);
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public List<FormField.Value> getRawValues() {
        return this.rawValues;
    }

    public List<Jid> getValues() {
        return this.values;
    }
}
