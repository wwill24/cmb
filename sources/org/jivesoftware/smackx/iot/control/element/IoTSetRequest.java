package org.jivesoftware.smackx.iot.control.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;

public class IoTSetRequest extends IQ {
    public static final String ELEMENT = "set";
    public static final String NAMESPACE = "urn:xmpp:iot:control";
    private final Collection<SetData> setData;

    public IoTSetRequest(Collection<? extends SetData> collection) {
        super("set", "urn:xmpp:iot:control");
        setType(IQ.Type.set);
        ArrayList arrayList = new ArrayList(collection.size());
        for (SetData add : collection) {
            arrayList.add(add);
        }
        this.setData = Collections.unmodifiableCollection(arrayList);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((Collection<? extends Element>) this.setData);
        return iQChildElementXmlStringBuilder;
    }

    public Collection<SetData> getSetData() {
        return this.setData;
    }
}
