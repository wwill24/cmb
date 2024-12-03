package org.jivesoftware.smack.debugger;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;

public class JulDebugger extends AbstractDebugger {
    private static final Logger LOGGER = Logger.getLogger(JulDebugger.class.getName());

    public JulDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        LOGGER.fine(str);
    }

    /* access modifiers changed from: protected */
    public void log(String str, Throwable th2) {
        LOGGER.log(Level.FINE, str, th2);
    }
}
