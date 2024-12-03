package dg;

import ag.j;
import com.google.crypto.tink.f;
import ig.g;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

public class c implements j<ag.c, ag.c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f23348a = Logger.getLogger(c.class.getName());

    private static class a implements ag.c {

        /* renamed from: a  reason: collision with root package name */
        private f<ag.c> f23349a;

        public a(f<ag.c> fVar) {
            this.f23349a = fVar;
        }

        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return g.a(this.f23349a.b().a(), this.f23349a.b().c().a(bArr, bArr2));
        }

        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (f.b c10 : this.f23349a.c(copyOfRange)) {
                    try {
                        return ((ag.c) c10.c()).b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e10) {
                        Logger d10 = c.f23348a;
                        d10.info("ciphertext prefix matches a key, but cannot decrypt: " + e10.toString());
                    }
                }
            }
            for (f.b c11 : this.f23349a.e()) {
                try {
                    return ((ag.c) c11.c()).b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    c() {
    }

    public static void e() throws GeneralSecurityException {
        com.google.crypto.tink.g.r(new c());
    }

    public Class<ag.c> b() {
        return ag.c.class;
    }

    public Class<ag.c> c() {
        return ag.c.class;
    }

    /* renamed from: f */
    public ag.c a(f<ag.c> fVar) {
        return new a(fVar);
    }
}
