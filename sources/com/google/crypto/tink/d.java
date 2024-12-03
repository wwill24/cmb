package com.google.crypto.tink;

import ag.e;
import ag.f;
import com.google.crypto.tink.proto.a;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.o;
import hg.t;
import hg.z;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f20562a;

    private d(a aVar) {
        this.f20562a = aVar;
    }

    public static void a(t tVar) throws GeneralSecurityException {
        if (tVar == null || tVar.F().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static void b(a aVar) throws GeneralSecurityException {
        if (aVar == null || aVar.I() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static a c(t tVar, ag.a aVar) throws GeneralSecurityException {
        try {
            a M = a.M(aVar.b(tVar.F().y(), new byte[0]), o.b());
            b(M);
            return M;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static t d(a aVar, ag.a aVar2) throws GeneralSecurityException {
        byte[] a10 = aVar2.a(aVar.toByteArray(), new byte[0]);
        try {
            if (a.M(aVar2.b(a10, new byte[0]), o.b()).equals(aVar)) {
                return (t) t.G().r(ByteString.i(a10)).s(h.b(aVar)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    static final d e(a aVar) throws GeneralSecurityException {
        b(aVar);
        return new d(aVar);
    }

    private <B, P> P i(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        return g.t(g.l(this, cls2), cls);
    }

    public static final d j(e eVar, ag.a aVar) throws GeneralSecurityException, IOException {
        t a10 = eVar.a();
        a(a10);
        return new d(c(a10, aVar));
    }

    /* access modifiers changed from: package-private */
    public a f() {
        return this.f20562a;
    }

    public z g() {
        return h.b(this.f20562a);
    }

    public <P> P h(Class<P> cls) throws GeneralSecurityException {
        Class<?> e10 = g.e(cls);
        if (e10 != null) {
            return i(cls, e10);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public void k(f fVar, ag.a aVar) throws GeneralSecurityException, IOException {
        fVar.b(d(this.f20562a, aVar));
    }

    public String toString() {
        return g().toString();
    }
}
