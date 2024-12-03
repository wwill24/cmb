package org.bouncycastle.jcajce.provider.keystore.util;

import java.io.IOException;
import java.security.KeyStore;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class ParameterUtil {
    public static char[] extractPassword(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException {
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            return null;
        }
        if (protectionParameter instanceof KeyStore.PasswordProtection) {
            return ((KeyStore.PasswordProtection) protectionParameter).getPassword();
        }
        if (protectionParameter instanceof KeyStore.CallbackHandlerProtection) {
            CallbackHandler callbackHandler = ((KeyStore.CallbackHandlerProtection) protectionParameter).getCallbackHandler();
            PasswordCallback passwordCallback = new PasswordCallback("password: ", false);
            try {
                callbackHandler.handle(new Callback[]{passwordCallback});
                return passwordCallback.getPassword();
            } catch (UnsupportedCallbackException e10) {
                throw new IllegalArgumentException("PasswordCallback not recognised: " + e10.getMessage(), e10);
            }
        } else {
            throw new IllegalArgumentException("no support for protection parameter of type " + protectionParameter.getClass().getName());
        }
    }
}
