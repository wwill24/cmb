package org.jivesoftware.smackx.pubsub.form;

import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class SubscribeForm extends Form implements SubscribeFormReader {
    public SubscribeForm(DataForm dataForm) {
        super(dataForm);
        FilledForm.ensureFormType(dataForm, SubscribeFormReader.FORM_TYPE);
    }

    public FillableSubscribeForm getFillableForm() {
        return new FillableSubscribeForm(getDataForm());
    }
}
