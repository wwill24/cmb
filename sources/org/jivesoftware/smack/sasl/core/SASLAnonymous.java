package org.jivesoftware.smack.sasl.core;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;

public class SASLAnonymous extends SASLMechanism {
    public static final String NAME = "ANONYMOUS";

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
    }

    public void checkIfSuccessfulOrThrow() {
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        return null;
    }

    public String getName() {
        return NAME;
    }

    public int getPriority() {
        return 500;
    }

    public boolean requiresPassword() {
        return false;
    }

    public SASLAnonymous newInstance() {
        return new SASLAnonymous();
    }
}
