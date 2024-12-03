package org.jivesoftware.smack.sasl;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public enum SASLError {
    aborted,
    account_disabled,
    credentials_expired,
    encryption_required,
    incorrect_encoding,
    invalid_authzid,
    invalid_mechanism,
    malformed_request,
    mechanism_too_weak,
    not_authorized,
    temporary_auth_failure;
    
    private static final Logger LOGGER = null;

    static {
        LOGGER = Logger.getLogger(SASLError.class.getName());
    }

    public static SASLError fromString(String str) {
        String replace = str.replace(SignatureVisitor.SUPER, '_');
        try {
            return valueOf(replace);
        } catch (Exception e10) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Could not transform string '" + replace + "' to SASLError", e10);
            return null;
        }
    }

    public String toString() {
        return name().replace('_', SignatureVisitor.SUPER);
    }
}
