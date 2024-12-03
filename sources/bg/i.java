package bg;

import ag.h;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.a0;
import hg.b0;
import ig.w;
import java.security.GeneralSecurityException;

public class i extends c<a0> {

    class a extends c.b<ag.a, a0> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(a0 a0Var) throws GeneralSecurityException {
            String E = a0Var.F().E();
            return h.a(E).b(E);
        }
    }

    class b extends c.a<b0, a0> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public a0 a(b0 b0Var) throws GeneralSecurityException {
            return (a0) a0.H().r(b0Var).s(i.this.j()).build();
        }

        /* renamed from: f */
        public b0 c(ByteString byteString) throws InvalidProtocolBufferException {
            return b0.F(byteString, o.b());
        }

        /* renamed from: g */
        public void d(b0 b0Var) throws GeneralSecurityException {
        }
    }

    i() {
        super(a0.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new i(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public c.a<b0, a0> e() {
        return new b(b0.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public a0 g(ByteString byteString) throws InvalidProtocolBufferException {
        return a0.I(byteString, o.b());
    }

    /* renamed from: m */
    public void i(a0 a0Var) throws GeneralSecurityException {
        w.c(a0Var.G(), j());
    }
}
