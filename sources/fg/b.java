package fg;

import ag.i;
import com.google.crypto.tink.c;
import com.google.crypto.tink.g;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.u;
import hg.v;
import hg.w;
import ig.s;
import ig.t;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class b extends com.google.crypto.tink.c<u> {

    class a extends c.b<i, u> {
        a(Class cls) {
            super(cls);
        }

        /* renamed from: c */
        public i a(u uVar) throws GeneralSecurityException {
            HashType E = uVar.I().E();
            SecretKeySpec secretKeySpec = new SecretKeySpec(uVar.H().y(), "HMAC");
            int F = uVar.I().F();
            int i10 = c.f23421a[E.ordinal()];
            if (i10 == 1) {
                return new t(new s("HMACSHA1", secretKeySpec), F);
            }
            if (i10 == 2) {
                return new t(new s("HMACSHA256", secretKeySpec), F);
            }
            if (i10 == 3) {
                return new t(new s("HMACSHA512", secretKeySpec), F);
            }
            throw new GeneralSecurityException("unknown hash");
        }
    }

    /* renamed from: fg.b$b  reason: collision with other inner class name */
    class C0277b extends c.a<v, u> {
        C0277b(Class cls) {
            super(cls);
        }

        /* renamed from: e */
        public u a(v vVar) throws GeneralSecurityException {
            return (u) u.K().t(b.this.k()).s(vVar.F()).r(ByteString.i(ig.u.c(vVar.E()))).build();
        }

        /* renamed from: f */
        public v c(ByteString byteString) throws InvalidProtocolBufferException {
            return v.G(byteString, o.b());
        }

        /* renamed from: g */
        public void d(v vVar) throws GeneralSecurityException {
            if (vVar.E() >= 16) {
                b.o(vVar.F());
                return;
            }
            throw new GeneralSecurityException("key too short");
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23421a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.crypto.tink.proto.HashType[] r0 = com.google.crypto.tink.proto.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23421a = r0
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23421a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23421a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.HashType r1 = com.google.crypto.tink.proto.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fg.b.c.<clinit>():void");
        }
    }

    public b() {
        super(u.class, new a(i.class));
    }

    public static void m(boolean z10) throws GeneralSecurityException {
        g.q(new b(), z10);
    }

    /* access modifiers changed from: private */
    public static void o(w wVar) throws GeneralSecurityException {
        if (wVar.F() >= 10) {
            int i10 = c.f23421a[wVar.E().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (wVar.F() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (wVar.F() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (wVar.F() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public c.a<v, u> e() {
        return new C0277b(v.class);
    }

    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    /* renamed from: l */
    public u g(ByteString byteString) throws InvalidProtocolBufferException {
        return u.L(byteString, o.b());
    }

    /* renamed from: n */
    public void i(u uVar) throws GeneralSecurityException {
        ig.w.c(uVar.J(), k());
        if (uVar.H().size() >= 16) {
            o(uVar.I());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
