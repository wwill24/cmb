package org.jivesoftware.smackx.xdata;

import java.util.List;
import org.jivesoftware.smackx.xdata.FormField;

public interface FormFieldWithOptions {

    public interface Builder<B extends FormField.Builder<?, ?>> {
        B addOption(String str) {
            return addOption(new FormField.Option(str));
        }

        B addOption(FormField.Option option);
    }

    List<FormField.Option> getOptions();
}
