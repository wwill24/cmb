package org.jivesoftware.smackx.xdata.form;

import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class Form extends FilledForm {
    public Form(DataForm dataForm) {
        super(dataForm);
        if (dataForm.getType() != DataForm.Type.form) {
            throw new IllegalArgumentException();
        }
    }

    public static Form from(StanzaView stanzaView) {
        DataForm from = DataForm.from(stanzaView);
        if (from == null || from.getType() != DataForm.Type.form) {
            return null;
        }
        return new Form(from);
    }

    public FillableForm getFillableForm() {
        return new FillableForm(getDataForm());
    }
}
