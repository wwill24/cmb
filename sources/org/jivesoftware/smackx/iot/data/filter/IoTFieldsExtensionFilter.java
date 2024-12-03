package org.jivesoftware.smackx.iot.data.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;

public class IoTFieldsExtensionFilter extends FlexibleStanzaTypeFilter<Message> {
    private final boolean onlyDone;
    private final int seqNr;

    public IoTFieldsExtensionFilter(int i10, boolean z10) {
        this.seqNr = i10;
        this.onlyDone = z10;
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Message message) {
        IoTFieldsExtension from = IoTFieldsExtension.from(message);
        if (from == null || from.getSequenceNr() != this.seqNr) {
            return false;
        }
        if (!this.onlyDone || from.isDone()) {
            return true;
        }
        return false;
    }
}
