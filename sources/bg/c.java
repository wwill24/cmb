package bg;

import ag.i;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.d;
import hg.e;
import ig.l;
import ig.p;
import ig.w;
import java.security.GeneralSecurityException;

public final class c extends com.google.crypto.tink.c<d> {

    class a extends c.b<ag.a, d> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(d dVar) throws GeneralSecurityException {
            return new l((p) new d().d(dVar.G(), p.class), (i) new fg.b().d(dVar.H(), i.class), dVar.H().I().F());
        }
    }

    class b extends c.a<e, d> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public d a(e eVar) throws GeneralSecurityException {
            return (d) d.J().r(new d().e().a(eVar.D())).s(new fg.b().e().a(eVar.E())).t(c.this.j()).build();
        }

        /* renamed from: f */
        public e c(ByteString byteString) throws InvalidProtocolBufferException {
            return e.F(byteString, o.b());
        }

        /* renamed from: g */
        public void d(e eVar) throws GeneralSecurityException {
            new d().e().d(eVar.D());
            new fg.b().e().d(eVar.E());
            w.a(eVar.D().E());
        }
    }

    c() {
        super(d.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new c(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public c.a<e, d> e() {
        return new b(e.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public d g(ByteString byteString) throws InvalidProtocolBufferException {
        return d.K(byteString, o.b());
    }

    /* renamed from: m */
    public void i(d dVar) throws GeneralSecurityException {
        w.c(dVar.I(), j());
        new d().i(dVar.G());
        new fg.b().i(dVar.H());
    }
}
