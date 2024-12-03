package org.jivesoftware.smackx.ox.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.util.SecurityUtil;

public class OpenPgpInitializer extends UrlInitializer {
    static {
        SecurityUtil.ensureProviderAtFirstPosition(BouncyCastleProvider.class);
    }

    /* access modifiers changed from: protected */
    public String getProvidersUri() {
        return "classpath:org.jivesoftware.smackx.ox/openpgp.providers";
    }
}
