package bg;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.l;
import hg.m;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;

public final class f extends c<l> {

    class a extends c.b<ag.a, l> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(l lVar) throws GeneralSecurityException {
            return new ig.c(lVar.F().y());
        }
    }

    class b extends c.a<m, l> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public l a(m mVar) throws GeneralSecurityException {
            return (l) l.H().r(ByteString.i(u.c(mVar.E()))).s(f.this.l()).build();
        }

        /* renamed from: f */
        public m c(ByteString byteString) throws InvalidProtocolBufferException {
            return m.G(byteString, o.b());
        }

        /* renamed from: g */
        public void d(m mVar) throws GeneralSecurityException {
            w.a(mVar.E());
        }
    }

    f() {
        super(l.class, new a(ag.a.class));
    }

    public static final KeyTemplate j() {
        return k(32, KeyTemplate.OutputPrefixType.TINK);
    }

    private static KeyTemplate k(int i10, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new f().c(), ((m) m.F().r(i10).build()).toByteArray(), outputPrefixType);
    }

    public static void n(boolean z10) throws GeneralSecurityException {
        g.q(new f(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public c.a<m, l> e() {
        return new b(m.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    /* renamed from: m */
    public l g(ByteString byteString) throws InvalidProtocolBufferException {
        return l.I(byteString, o.b());
    }

    /* renamed from: o */
    public void i(l lVar) throws GeneralSecurityException {
        w.c(lVar.G(), l());
        w.a(lVar.F().size());
    }
}
