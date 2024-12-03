package io.sentry;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.util.l;
import java.net.URI;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f31329a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31330b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31331c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31332d;

    /* renamed from: e  reason: collision with root package name */
    private final URI f31333e;

    m(String str) throws IllegalArgumentException {
        String str2;
        try {
            l.c(str, "The DSN is required.");
            URI normalize = new URI(str).normalize();
            String userInfo = normalize.getUserInfo();
            if (userInfo != null) {
                if (!userInfo.isEmpty()) {
                    String[] split = userInfo.split(CertificateUtil.DELIMITER, -1);
                    String str3 = split[0];
                    this.f31332d = str3;
                    if (str3 == null || str3.isEmpty()) {
                        throw new IllegalArgumentException("Invalid DSN: No public key provided.");
                    }
                    if (split.length > 1) {
                        str2 = split[1];
                    } else {
                        str2 = null;
                    }
                    this.f31331c = str2;
                    String path = normalize.getPath();
                    path = path.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? path.substring(0, path.length() - 1) : path;
                    int lastIndexOf = path.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1;
                    String substring = path.substring(0, lastIndexOf);
                    if (!substring.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        substring = substring + RemoteSettings.FORWARD_SLASH_STRING;
                    }
                    this.f31330b = substring;
                    String substring2 = path.substring(lastIndexOf);
                    this.f31329a = substring2;
                    if (!substring2.isEmpty()) {
                        this.f31333e = new URI(normalize.getScheme(), (String) null, normalize.getHost(), normalize.getPort(), substring + "api/" + substring2, (String) null, (String) null);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
                }
            }
            throw new IllegalArgumentException("Invalid DSN: No public key provided.");
        } catch (Throwable th2) {
            throw new IllegalArgumentException(th2);
        }
    }

    public String a() {
        return this.f31332d;
    }

    public String b() {
        return this.f31331c;
    }

    /* access modifiers changed from: package-private */
    public URI c() {
        return this.f31333e;
    }
}
