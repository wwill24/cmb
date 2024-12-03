package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;

public class ListMultiFormField extends AbstractMultiFormField implements FormFieldWithOptions {
    private final List<FormField.Option> options;

    public static final class Builder extends AbstractMultiFormField.Builder<ListMultiFormField, Builder> implements FormFieldWithOptions.Builder<Builder> {
        /* access modifiers changed from: private */
        public List<FormField.Option> options;

        public Builder getThis() {
            return this;
        }

        private Builder(ListMultiFormField listMultiFormField) {
            super(listMultiFormField);
        }

        public Builder addOption(FormField.Option option) {
            if (this.options == null) {
                this.options = new ArrayList();
            }
            this.options.add(option);
            return this;
        }

        public Builder addValue(CharSequence charSequence) {
            return (Builder) super.addValueVerbatim(charSequence);
        }

        public ListMultiFormField build() {
            return new ListMultiFormField(this);
        }

        Builder(String str) {
            super(str, FormField.Type.list_multi);
        }
    }

    protected ListMultiFormField(Builder builder) {
        super(builder);
        this.options = CollectionUtil.cloneAndSeal(builder.options);
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public List<FormField.Option> getOptions() {
        return this.options;
    }

    /* access modifiers changed from: protected */
    public void populateExtraXmlChildElements() {
        super.populateExtraXmlChildElements();
        this.extraXmlChildElements.addAll(this.options);
    }
}
