package bg;

import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.i;
import hg.j;
import ig.u;
import ig.w;
import java.security.GeneralSecurityException;

public final class e extends c<i> {

    class a extends c.b<ag.a, i> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public ag.a a(i iVar) throws GeneralSecurityException {
            return new ig.b(iVar.G().y(), iVar.H().E());
        }
    }

    class b extends c.a<j, i> {
        b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public i a(j jVar) throws GeneralSecurityException {
            return (i) i.J().r(ByteString.i(u.c(jVar.D()))).s(jVar.E()).t(e.this.j()).build();
        }

        /* renamed from: f */
        public j c(ByteString byteString) throws InvalidProtocolBufferException {
            return j.F(byteString, o.b());
        }

        /* renamed from: g */
        public void d(j jVar) throws GeneralSecurityException {
            w.a(jVar.D());
            if (jVar.E().E() != 12 && jVar.E().E() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
        }
    }

    e() {
        super(i.class, new a(ag.a.class));
    }

    public static void l(boolean z10) throws GeneralSecurityException {
        g.q(new e(), z10);
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public c.a<j, i> e() {
        return new b(j.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int j() {
        return 0;
    }

    /* renamed from: k */
    public i g(ByteString byteString) throws InvalidProtocolBufferException {
        return i.K(byteString, o.b());
    }

    /* renamed from: m */
    public void i(i iVar) throws GeneralSecurityException {
        w.c(iVar.I(), j());
        w.a(iVar.G().size());
        if (iVar.H().E() != 12 && iVar.H().E() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
