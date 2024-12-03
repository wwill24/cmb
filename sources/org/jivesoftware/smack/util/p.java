package org.jivesoftware.smack.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class p implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        return TLSUtils.lambda$disableHostnameVerificationForTlsCertificates$0(str, sSLSession);
    }
}
