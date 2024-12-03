package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jxmpp.jid.EntityBareJid;

public class SASLPlainMechanism extends SASLMechanism {
    public static final String NAME = "PLAIN";

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    public boolean authzidSupported() {
        return true;
    }

    public void checkIfSuccessfulOrThrow() {
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        String str;
        EntityBareJid entityBareJid = this.authorizationId;
        if (entityBareJid == null) {
            str = "";
        } else {
            str = entityBareJid.toString();
        }
        byte[] bytes = SASLMechanism.toBytes(str + 0 + this.authenticationId);
        return ByteUtils.concat(bytes, SASLMechanism.toBytes(0 + this.password));
    }

    public String getName() {
        return "PLAIN";
    }

    public int getPriority() {
        return 410;
    }

    public SASLPlainMechanism newInstance() {
        return new SASLPlainMechanism();
    }
}
