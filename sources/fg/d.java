package fg;

import ag.i;
import ag.j;
import com.google.crypto.tink.f;
import com.google.crypto.tink.proto.OutputPrefixType;
import ig.g;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

class d implements j<i, i> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f23426a = Logger.getLogger(d.class.getName());

    private static class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final f<i> f23427a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f23428b;

        public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (f.b next : this.f23427a.c(copyOf)) {
                    try {
                        if (next.b().equals(OutputPrefixType.LEGACY)) {
                            ((i) next.c()).a(copyOfRange, g.a(bArr2, this.f23428b));
                            return;
                        }
                        ((i) next.c()).a(copyOfRange, bArr2);
                        return;
                    } catch (GeneralSecurityException e10) {
                        Logger d10 = d.f23426a;
                        d10.info("tag prefix matches a key, but cannot verify: " + e10);
                    }
                }
                for (f.b c10 : this.f23427a.e()) {
                    try {
                        ((i) c10.c()).a(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }

        public byte[] b(byte[] bArr) throws GeneralSecurityException {
            if (this.f23427a.b().b().equals(OutputPrefixType.LEGACY)) {
                return g.a(this.f23427a.b().a(), this.f23427a.b().c().b(g.a(bArr, this.f23428b)));
            }
            return g.a(this.f23427a.b().a(), this.f23427a.b().c().b(bArr));
        }

        private b(f<i> fVar) {
            this.f23428b = new byte[]{0};
            this.f23427a = fVar;
        }
    }

    d() {
    }

    public static void e() throws GeneralSecurityException {
        com.google.crypto.tink.g.r(new d());
    }

    public Class<i> b() {
        return i.class;
    }

    public Class<i> c() {
        return i.class;
    }

    /* renamed from: f */
    public i a(f<i> fVar) throws GeneralSecurityException {
        return new b(fVar);
    }
}
