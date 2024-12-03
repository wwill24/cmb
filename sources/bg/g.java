package bg;

import com.google.crypto.tink.c;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import hg.n;
import hg.o;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class g extends c<n> {

    class a extends c.b<ag.a, n> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(n nVar) throws GeneralSecurityException {
            return new cg.a(nVar.F().y());
        }
    }

    class b extends c.a<o, n> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public n a(o oVar) {
            return (n) n.H().r(ByteString.i(u.c(oVar.D()))).s(g.this.k()).build();
        }

        /* renamed from: f */
        public o c(ByteString byteString) throws InvalidProtocolBufferException {
            return o.E(byteString, com.google.crypto.tink.shaded.protobuf.o.b());
        }

        /* renamed from: g */
        public void d(o oVar) throws GeneralSecurityException {
            w.a(oVar.D());
        }
    }

    g() {
        super(n.class, new a(ag.a.class));
    }

    private static boolean j() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void m(boolean z10) throws GeneralSecurityException {
        if (j()) {
            com.google.crypto.tink.g.q(new g(), z10);
        }
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public c.a<o, n> e() {
        return new b(o.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    /* renamed from: l */
    public n g(ByteString byteString) throws InvalidProtocolBufferException {
        return n.I(byteString, com.google.crypto.tink.shaded.protobuf.o.b());
    }

    /* renamed from: n */
    public void i(n nVar) throws GeneralSecurityException {
        w.c(nVar.G(), k());
        w.a(nVar.F().size());
    }
}
