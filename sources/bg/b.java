package bg;

import ag.j;
import com.google.crypto.tink.f;
import ig.g;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class b implements j<ag.a, ag.a> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f18912a = Logger.getLogger(b.class.getName());

    /* renamed from: bg.b$b  reason: collision with other inner class name */
    private static class C0228b implements ag.a {

        /* renamed from: a  reason: collision with root package name */
        private final f<ag.a> f18913a;

        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return g.a(this.f18913a.b().a(), this.f18913a.b().c().a(bArr, bArr2));
        }

        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (f.b c10 : this.f18913a.c(copyOfRange)) {
                    try {
                        return ((ag.a) c10.c()).b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e10) {
                        Logger d10 = b.f18912a;
                        d10.info("ciphertext prefix matches a key, but cannot decrypt: " + e10.toString());
                    }
                }
            }
            for (f.b c11 : this.f18913a.e()) {
                try {
                    return ((ag.a) c11.c()).b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        private C0228b(f<ag.a> fVar) {
            this.f18913a = fVar;
        }
    }

    b() {
    }

    public static void e() throws GeneralSecurityException {
        com.google.crypto.tink.g.r(new b());
    }

    public Class<ag.a> b() {
        return ag.a.class;
    }

    public Class<ag.a> c() {
        return ag.a.class;
    }

    /* renamed from: f */
    public ag.a a(f<ag.a> fVar) throws GeneralSecurityException {
        return new C0228b(fVar);
    }
}
