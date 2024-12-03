package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class ConfigureForm extends Form implements ConfigureFormReader {
    public ConfigureForm(DataForm dataForm) {
        super(dataForm);
        FilledForm.ensureFormType(dataForm, ConfigureFormReader.FORM_TYPE);
    }

    public FillableConfigureForm getFillableForm() {
        return new FillableConfigureForm(getDataForm());
    }
}
