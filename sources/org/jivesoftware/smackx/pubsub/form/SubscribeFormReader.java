package org.jivesoftware.smackx.pubsub.form;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smackx.pubsub.PresenceState;
import org.jivesoftware.smackx.pubsub.SubscribeOptionFields;
import org.jivesoftware.smackx.xdata.form.FormReader;

public interface SubscribeFormReader extends FormReader {
    public static final String FORM_TYPE = "http://jabber.org/protocol/pubsub#subscribe_options";

    Integer getDigestFrequency() {
        return readInteger(SubscribeOptionFields.digest_frequency.getFieldName());
    }

    Date getExpiry() throws ParseException {
        return readDate(SubscribeOptionFields.expire.getFieldName());
    }

    List<PresenceState> getShowValues() {
        List<String> readStringValues = readStringValues(SubscribeOptionFields.show_values.getFieldName());
        ArrayList arrayList = new ArrayList(readStringValues.size());
        for (String valueOf : readStringValues) {
            arrayList.add(PresenceState.valueOf(valueOf));
        }
        return arrayList;
    }

    boolean isDeliverOn() {
        return readBoolean(SubscribeOptionFields.deliver.getFieldName()).booleanValue();
    }

    Boolean isDigestOn() {
        return readBoolean(SubscribeOptionFields.digest.getFieldName());
    }

    Boolean isIncludeBody() {
        return readBoolean(SubscribeOptionFields.include_body.getFieldName());
    }
}
