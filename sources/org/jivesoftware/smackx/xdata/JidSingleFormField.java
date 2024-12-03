package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class JidSingleFormField extends SingleValueFormField {
    private final Jid value;

    public static final class Builder extends SingleValueFormField.Builder<JidSingleFormField, Builder> {
        /* access modifiers changed from: private */
        public Jid value;

        public Builder getThis() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void resetInternal() {
            super.resetInternal();
            this.value = null;
        }

        public Builder setValue(Jid jid) {
            this.value = jid;
            this.rawValue = new FormField.Value(jid);
            return getThis();
        }

        private Builder(JidSingleFormField jidSingleFormField) {
            super(jidSingleFormField);
            this.value = jidSingleFormField.getValue();
        }

        public JidSingleFormField build() {
            return new JidSingleFormField(this);
        }

        Builder(String str) {
            super(str, FormField.Type.jid_single);
        }

        public Builder setValue(FormField.Value value2) throws XmppStringprepException {
            this.value = a.n(value2.getValue());
            this.rawValue = value2;
            return this;
        }
    }

    protected JidSingleFormField(Builder builder) {
        super(builder);
        this.value = builder.value;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public Jid getValue() {
        return this.value;
    }
}
