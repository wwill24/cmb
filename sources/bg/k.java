package bg;

import ag.h;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.c0;
import hg.d0;
import ig.w;
import java.security.GeneralSecurityException;

public class k extends c<c0> {

    class a extends c.b<ag.a, c0> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(c0 c0Var) throws GeneralSecurityException {
            String F = c0Var.F().F();
            return new j(c0Var.F().E(), h.a(F).b(F));
        }
    }

    class b extends c.a<d0, c0> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public c0 a(d0 d0Var) throws GeneralSecurityException {
            return (c0) c0.H().r(d0Var).s(k.this.j()).build();
        }

        /* renamed from: f */
        public d0 c(ByteString byteString) throws InvalidProtocolBufferException {
            return d0.G(byteString, o.b());
        }

        /* renamed from: g */
        public void d(d0 d0Var) throws GeneralSecurityException {
        }
    }

    k() {
        super(c0.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new k(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public c.a<d0, c0> e() {
        return new b(d0.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public c0 g(ByteString byteString) throws InvalidProtocolBufferException {
        return c0.I(byteString, o.b());
    }

    /* renamed from: m */
    public void i(c0 c0Var) throws GeneralSecurityException {
        w.c(c0Var.G(), j());
    }
}
