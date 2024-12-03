package org.jivesoftware.smack.iqrequest;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;

public interface IQRequestHandler {

    public enum Mode {
        sync,
        async
    }

    String getElement();

    Mode getMode();

    String getNamespace();

    QName getQName() {
        return new QName(getNamespace(), getElement());
    }

    IQ.Type getType();

    IQ handleIQRequest(IQ iq);
}
