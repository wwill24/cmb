package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FilledSubscribeForm extends FilledForm implements SubscribeFormReader {
    public FilledSubscribeForm(DataForm dataForm) {
        super(dataForm);
        FilledForm.ensureFormType(dataForm, SubscribeFormReader.FORM_TYPE);
    }
}
