package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import lm.c;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.EntityBareJid;

public class SASLExternalMechanism extends SASLMechanism {
    public static final String NAME = "EXTERNAL";

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
    }

    public boolean authzidSupported() {
        return true;
    }

    public void checkIfSuccessfulOrThrow() {
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        EntityBareJid entityBareJid = this.authorizationId;
        if (entityBareJid != null) {
            return SASLMechanism.toBytes(entityBareJid.toString());
        }
        if (StringUtils.isNullOrEmpty((CharSequence) this.authenticationId)) {
            return null;
        }
        return SASLMechanism.toBytes(c.a(this.authenticationId, this.serviceName));
    }

    public String getName() {
        return "EXTERNAL";
    }

    public int getPriority() {
        return 510;
    }

    /* access modifiers changed from: protected */
    public SASLMechanism newInstance() {
        return new SASLExternalMechanism();
    }

    public boolean requiresPassword() {
        return false;
    }
}
