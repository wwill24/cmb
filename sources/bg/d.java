package bg;

import com.google.crypto.tink.c;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.f;
import hg.g;
import hg.h;
import ig.p;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;

public class d extends c<f> {

    class a extends c.b<p, f> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public p a(f fVar) throws GeneralSecurityException {
            return new ig.a(fVar.H().y(), fVar.I().E());
        }
    }

    class b extends c.a<g, f> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public f a(g gVar) throws GeneralSecurityException {
            return (f) f.K().s(gVar.F()).r(ByteString.i(u.c(gVar.E()))).t(d.this.k()).build();
        }

        /* renamed from: f */
        public g c(ByteString byteString) throws InvalidProtocolBufferException {
            return g.G(byteString, o.b());
        }

        /* renamed from: g */
        public void d(g gVar) throws GeneralSecurityException {
            w.a(gVar.E());
            d.this.n(gVar.F());
        }
    }

    d() {
        super(f.class, new a(p.class));
    }

    /* access modifiers changed from: private */
    public void n(h hVar) throws GeneralSecurityException {
        if (hVar.E() < 12 || hVar.E() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public c.a<g, f> e() {
        return new b(g.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    /* renamed from: l */
    public f g(ByteString byteString) throws InvalidProtocolBufferException {
        return f.L(byteString, o.b());
    }

    /* renamed from: m */
    public void i(f fVar) throws GeneralSecurityException {
        w.c(fVar.J(), k());
        w.a(fVar.H().size());
        n(fVar.I());
    }
}
