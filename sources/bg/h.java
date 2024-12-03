package bg;

import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.r;
import hg.s;
import ig.j;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;

public class h extends c<r> {

    class a extends c.b<ag.a, r> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(r rVar) throws GeneralSecurityException {
            return new j(rVar.F().y());
        }
    }

    class b extends c.a<s, r> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public r a(s sVar) throws GeneralSecurityException {
            return (r) r.H().s(h.this.j()).r(ByteString.i(u.c(32))).build();
        }

        /* renamed from: f */
        public s c(ByteString byteString) throws InvalidProtocolBufferException {
            return s.D(byteString, o.b());
        }

        /* renamed from: g */
        public void d(s sVar) throws GeneralSecurityException {
        }
    }

    h() {
        super(r.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new h(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public c.a<s, r> e() {
        return new b(s.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public r g(ByteString byteString) throws InvalidProtocolBufferException {
        return r.I(byteString, o.b());
    }

    /* renamed from: m */
    public void i(r rVar) throws GeneralSecurityException {
        w.c(rVar.G(), j());
        if (rVar.F().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
