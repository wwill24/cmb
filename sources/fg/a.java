package fg;

import ag.i;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import ig.r;
import ig.t;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;

public final class a extends c<hg.a> {

    /* renamed from: fg.a$a  reason: collision with other inner class name */
    class C0276a extends c.b<i, hg.a> {
        C0276a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public i a(hg.a aVar) throws GeneralSecurityException {
            return new t(new r(aVar.G().y()), aVar.H().E());
        }
    }

    class b extends c.a<hg.b, hg.a> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public hg.a a(hg.b bVar) throws GeneralSecurityException {
            return (hg.a) hg.a.J().t(0).r(ByteString.i(u.c(bVar.D()))).s(bVar.E()).build();
        }

        /* renamed from: f */
        public hg.b c(ByteString byteString) throws InvalidProtocolBufferException {
            return hg.b.F(byteString, o.b());
        }

        /* renamed from: g */
        public void d(hg.b bVar) throws GeneralSecurityException {
            a.p(bVar.E());
            a.q(bVar.D());
        }
    }

    a() {
        super(hg.a.class, new C0276a(i.class));
    }

    public static void n(boolean z10) throws GeneralSecurityException {
        g.q(new a(), z10);
    }

    /* access modifiers changed from: private */
    public static void p(hg.c cVar) throws GeneralSecurityException {
        if (cVar.E() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (cVar.E() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void q(int i10) throws GeneralSecurityException {
        if (i10 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public c.a<hg.b, hg.a> e() {
        return new b(hg.b.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    /* renamed from: m */
    public hg.a g(ByteString byteString) throws InvalidProtocolBufferException {
        return hg.a.K(byteString, o.b());
    }

    /* renamed from: o */
    public void i(hg.a aVar) throws GeneralSecurityException {
        w.c(aVar.I(), l());
        q(aVar.G().size());
        p(aVar.H());
    }
}
