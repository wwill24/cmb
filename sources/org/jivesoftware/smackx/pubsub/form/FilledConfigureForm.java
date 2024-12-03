package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FilledConfigureForm extends FilledForm implements ConfigureFormReader {
    public FilledConfigureForm(DataForm dataForm) {
        super(dataForm);
        FilledForm.ensureFormType(dataForm, ConfigureFormReader.FORM_TYPE);
    }
}
