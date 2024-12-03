package org.jivesoftware.smackx.pubsub.form;

import java.util.Collection;
import java.util.Date;
import org.jivesoftware.smackx.pubsub.PresenceState;
import org.jivesoftware.smackx.pubsub.SubscribeOptionFields;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FillableSubscribeForm extends FillableForm implements SubscribeFormReader {
    FillableSubscribeForm(DataForm dataForm) {
        super(dataForm);
    }

    public void setDeliverOn(boolean z10) {
        writeBoolean(SubscribeOptionFields.deliver.getFieldName(), z10);
    }

    public void setDigestFrequency(int i10) {
        write(SubscribeOptionFields.digest_frequency.getFieldName(), i10);
    }

    public void setDigestOn(boolean z10) {
        writeBoolean(SubscribeOptionFields.digest.getFieldName(), z10);
    }

    public void setExpiry(Date date) {
        write(SubscribeOptionFields.expire.getFieldName(), date);
    }

    public void setIncludeBody(boolean z10) {
        writeBoolean(SubscribeOptionFields.include_body.getFieldName(), z10);
    }

    public void setShowValues(Collection<PresenceState> collection) {
        ListMultiFormField.Builder listMultiBuilder = FormField.listMultiBuilder(SubscribeOptionFields.show_values.getFieldName());
        for (PresenceState obj : collection) {
            listMultiBuilder.addValue((CharSequence) obj.toString());
        }
        write(listMultiBuilder.build());
    }
}
