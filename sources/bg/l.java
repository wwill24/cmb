package bg;

import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.f0;
import hg.g0;
import ig.u;
import ig.w;
import ig.y;
import java.security.GeneralSecurityException;

public class l extends c<f0> {

    class a extends c.b<ag.a, f0> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(f0 f0Var) throws GeneralSecurityException {
            return new y(f0Var.F().y());
        }
    }

    class b extends c.a<g0, f0> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public f0 a(g0 g0Var) throws GeneralSecurityException {
            return (f0) f0.H().s(l.this.j()).r(ByteString.i(u.c(32))).build();
        }

        /* renamed from: f */
        public g0 c(ByteString byteString) throws InvalidProtocolBufferException {
            return g0.D(byteString, o.b());
        }

        /* renamed from: g */
        public void d(g0 g0Var) throws GeneralSecurityException {
        }
    }

    l() {
        super(f0.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new l(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public c.a<g0, f0> e() {
        return new b(g0.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public f0 g(ByteString byteString) throws InvalidProtocolBufferException {
        return f0.I(byteString, o.b());
    }

    /* renamed from: m */
    public void i(f0 f0Var) throws GeneralSecurityException {
        w.c(f0Var.G(), j());
        if (f0Var.F().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
