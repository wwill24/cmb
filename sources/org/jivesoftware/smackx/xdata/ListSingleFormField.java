package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;

public class ListSingleFormField extends AbstractSingleStringValueFormField implements FormFieldWithOptions {
    private final List<FormField.Option> options;

    public static final class Builder extends AbstractSingleStringValueFormField.Builder<ListSingleFormField, Builder> implements FormFieldWithOptions.Builder<Builder> {
        /* access modifiers changed from: private */
        public List<FormField.Option> options;

        public Builder getThis() {
            return this;
        }

        private Builder(ListSingleFormField listSingleFormField) {
            super(listSingleFormField);
        }

        public Builder addOption(FormField.Option option) {
            if (this.options == null) {
                this.options = new ArrayList();
            }
            this.options.add(option);
            return this;
        }

        public ListSingleFormField build() {
            return new ListSingleFormField(this);
        }

        Builder(String str) {
            super(str, FormField.Type.list_single);
        }
    }

    protected ListSingleFormField(Builder builder) {
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
        this.extraXmlChildElements = new ArrayList(this.options.size() + 1);
        String value = getValue();
        if (value != null) {
            this.extraXmlChildElements.add(new FormField.Value(value));
        }
        this.extraXmlChildElements.addAll(this.options);
    }
}
