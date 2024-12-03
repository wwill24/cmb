package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class o implements Consumer {
    public final void accept(Object obj) {
        ((SmackDebugger) obj).onIncomingElementCompleted();
    }
}
