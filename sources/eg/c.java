package eg;

import ag.g;
import android.security.keystore.KeyGenParameterSpec;
import ig.u;
import ig.w;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f23386a;

    /* renamed from: b  reason: collision with root package name */
    private KeyStore f23387b;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        String f23388a = null;

        /* renamed from: b  reason: collision with root package name */
        KeyStore f23389b = null;

        public b() {
            if (c.f()) {
                try {
                    KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                    this.f23389b = instance;
                    instance.load((KeyStore.LoadStoreParameter) null);
                } catch (IOException | GeneralSecurityException e10) {
                    throw new IllegalStateException(e10);
                }
            } else {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
        }

        public c a() {
            return new c(this);
        }

        public b b(KeyStore keyStore) {
            if (keyStore != null) {
                this.f23389b = keyStore;
                return this;
            }
            throw new IllegalArgumentException("val cannot be null");
        }
    }

    public static void d(String str) throws GeneralSecurityException {
        if (!new c().e(str)) {
            String b10 = w.b("android-keystore://", str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(b10, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
            instance.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", new Object[]{str}));
    }

    /* access modifiers changed from: private */
    public static boolean f() {
        return true;
    }

    private static ag.a g(ag.a aVar) throws GeneralSecurityException {
        byte[] c10 = u.c(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(c10, aVar.b(aVar.a(c10, bArr), bArr))) {
            return aVar;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.f23386a     // Catch:{ all -> 0x0024 }
            r1 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r2)
            return r1
        L_0x000e:
            java.lang.String r0 = r2.f23386a     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0021
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0024 }
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            monitor-exit(r2)
            return r1
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eg.c.a(java.lang.String):boolean");
    }

    public synchronized ag.a b(String str) throws GeneralSecurityException {
        String str2 = this.f23386a;
        if (str2 != null) {
            if (!str2.equals(str)) {
                throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.f23386a, str}));
            }
        }
        return g(new b(w.b("android-keystore://", str), this.f23387b));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean e(java.lang.String r3) throws java.security.GeneralSecurityException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r3 = ig.w.b(r0, r3)     // Catch:{ all -> 0x002f }
            java.security.KeyStore r0 = r2.f23387b     // Catch:{ NullPointerException -> 0x000f }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ NullPointerException -> 0x000f }
            monitor-exit(r2)
            return r3
        L_0x000f:
            r0 = 20
            java.lang.Thread.sleep(r0)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            r2.f23387b = r0     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x0028, InterruptedException -> 0x0020 }
        L_0x0020:
            java.security.KeyStore r0 = r2.f23387b     // Catch:{ all -> 0x002f }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return r3
        L_0x0028:
            r3 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x002f }
            r0.<init>(r3)     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eg.c.e(java.lang.String):boolean");
    }

    public c() throws GeneralSecurityException {
        this(new b());
    }

    private c(b bVar) {
        this.f23386a = bVar.f23388a;
        this.f23387b = bVar.f23389b;
    }
}
