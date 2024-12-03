package eg;

import ag.f;
import android.content.Context;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.d;
import com.google.crypto.tink.e;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import eg.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f23373d = "a";

    /* renamed from: a  reason: collision with root package name */
    private final f f23374a;

    /* renamed from: b  reason: collision with root package name */
    private final ag.a f23375b;

    /* renamed from: c  reason: collision with root package name */
    private e f23376c;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private ag.e f23377a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public f f23378b = null;

        /* renamed from: c  reason: collision with root package name */
        private String f23379c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ag.a f23380d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f23381e = true;

        /* renamed from: f  reason: collision with root package name */
        private KeyTemplate f23382f = null;

        /* renamed from: g  reason: collision with root package name */
        private KeyStore f23383g = null;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public e f23384h;

        private e e() throws GeneralSecurityException, IOException {
            ag.a aVar = this.f23380d;
            if (aVar != null) {
                try {
                    return e.j(d.j(this.f23377a, aVar));
                } catch (InvalidProtocolBufferException | GeneralSecurityException unused) {
                    String unused2 = a.f23373d;
                }
            }
            return e.j(com.google.crypto.tink.a.a(this.f23377a));
        }

        private e f() throws GeneralSecurityException, IOException {
            try {
                return e();
            } catch (FileNotFoundException unused) {
                String unused2 = a.f23373d;
                if (this.f23382f != null) {
                    e a10 = e.i().a(this.f23382f);
                    e h10 = a10.h(a10.c().g().H(0).H());
                    if (this.f23380d != null) {
                        h10.c().k(this.f23378b, this.f23380d);
                    } else {
                        com.google.crypto.tink.a.b(h10.c(), this.f23378b);
                    }
                    return h10;
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        private ag.a g() throws GeneralSecurityException {
            c cVar;
            if (!a.d()) {
                String unused = a.f23373d;
                return null;
            }
            if (this.f23383g != null) {
                cVar = new c.b().b(this.f23383g).a();
            } else {
                cVar = new c();
            }
            boolean e10 = cVar.e(this.f23379c);
            if (!e10) {
                try {
                    c.d(this.f23379c);
                } catch (GeneralSecurityException | ProviderException unused2) {
                    String unused3 = a.f23373d;
                    return null;
                }
            }
            try {
                return cVar.b(this.f23379c);
            } catch (GeneralSecurityException | ProviderException e11) {
                if (!e10) {
                    String unused4 = a.f23373d;
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.f23379c}), e11);
            }
        }

        public synchronized a d() throws GeneralSecurityException, IOException {
            if (this.f23379c != null) {
                this.f23380d = g();
            }
            this.f23384h = f();
            return new a(this);
        }

        public b h(KeyTemplate keyTemplate) {
            this.f23382f = keyTemplate;
            return this;
        }

        public b i(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.f23381e) {
                this.f23379c = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public b j(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            } else if (str != null) {
                this.f23377a = new d(context, str, str2);
                this.f23378b = new e(context, str, str2);
                return this;
            } else {
                throw new IllegalArgumentException("need a keyset name");
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean d() {
        return true;
    }

    public synchronized d c() throws GeneralSecurityException {
        return this.f23376c.c();
    }

    private a(b bVar) throws GeneralSecurityException, IOException {
        this.f23374a = bVar.f23378b;
        this.f23375b = bVar.f23380d;
        this.f23376c = bVar.f23384h;
    }
}
