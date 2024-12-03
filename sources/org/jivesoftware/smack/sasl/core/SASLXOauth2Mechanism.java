package org.jivesoftware.smack.sasl.core;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;

public class SASLXOauth2Mechanism extends SASLMechanism {
    public static final String NAME = "X-OAUTH2";

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    public void checkIfSuccessfulOrThrow() {
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        return SASLMechanism.toBytes(0 + this.authenticationId + 0 + this.password);
    }

    public String getName() {
        return NAME;
    }

    public int getPriority() {
        return 410;
    }

    public SASLXOauth2Mechanism newInstance() {
        return new SASLXOauth2Mechanism();
    }
}
