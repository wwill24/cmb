package dg;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.p;
import hg.q;
import ig.d;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public final class a extends c<p> {

    /* renamed from: dg.a$a  reason: collision with other inner class name */
    class C0270a extends c.b<ag.c, p> {
        C0270a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.c a(p pVar) throws GeneralSecurityException {
            return new d(pVar.F().y());
        }
    }

    class b extends c.a<q, p> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public p a(q qVar) throws GeneralSecurityException {
            return (p) p.H().r(ByteString.i(u.c(qVar.E()))).s(a.this.l()).build();
        }

        /* renamed from: f */
        public q c(ByteString byteString) throws InvalidProtocolBufferException {
            return q.G(byteString, o.b());
        }

        /* renamed from: g */
        public void d(q qVar) throws GeneralSecurityException {
            if (qVar.E() != 64) {
                throw new InvalidAlgorithmParameterException("invalid key size: " + qVar.E() + ". Valid keys must have 64 bytes.");
            }
        }
    }

    a() {
        super(p.class, new C0270a(ag.c.class));
    }

    public static final KeyTemplate j() {
        return k(64, KeyTemplate.OutputPrefixType.TINK);
    }

    private static KeyTemplate k(int i10, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new a().c(), ((q) q.F().r(i10).build()).toByteArray(), outputPrefixType);
    }

    public static void n(boolean z10) throws GeneralSecurityException {
        g.q(new a(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public c.a<q, p> e() {
        return new b(q.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    /* renamed from: m */
    public p g(ByteString byteString) throws InvalidProtocolBufferException {
        return p.I(byteString, o.b());
    }

    /* renamed from: o */
    public void i(p pVar) throws GeneralSecurityException {
        w.c(pVar.G(), l());
        if (pVar.F().size() != 64) {
            throw new InvalidKeyException("invalid key size: " + pVar.F().size() + ". Valid keys must have 64 bytes.");
        }
    }
}
