package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return StanzaBuilder.buildIqData((String) obj);
    }
}
