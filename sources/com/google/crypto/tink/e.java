package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.a;
import hg.x;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final a.b f20563a;

    private e(a.b bVar) {
        this.f20563a = bVar;
    }

    private synchronized boolean d(int i10) {
        for (a.c I : this.f20563a.u()) {
            if (I.I() == i10) {
                return true;
            }
        }
        return false;
    }

    private synchronized a.c e(x xVar) throws GeneralSecurityException {
        KeyData p10;
        int f10;
        OutputPrefixType H;
        p10 = g.p(xVar);
        f10 = f();
        H = xVar.H();
        if (H == OutputPrefixType.UNKNOWN_PREFIX) {
            H = OutputPrefixType.TINK;
        }
        return (a.c) a.c.M().r(p10).s(f10).u(KeyStatusType.ENABLED).t(H).build();
    }

    private synchronized int f() {
        int g10;
        g10 = g();
        while (d(g10)) {
            g10 = g();
        }
        return g10;
    }

    private static int g() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b10 = 0;
        while (b10 == 0) {
            secureRandom.nextBytes(bArr);
            b10 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b10;
    }

    public static e i() {
        return new e(a.L());
    }

    public static e j(d dVar) {
        return new e((a.b) dVar.f().toBuilder());
    }

    public synchronized e a(KeyTemplate keyTemplate) throws GeneralSecurityException {
        b(keyTemplate.b(), false);
        return this;
    }

    @Deprecated
    public synchronized int b(x xVar, boolean z10) throws GeneralSecurityException {
        a.c e10;
        e10 = e(xVar);
        this.f20563a.r(e10);
        if (z10) {
            this.f20563a.v(e10.I());
        }
        return e10.I();
    }

    public synchronized d c() throws GeneralSecurityException {
        return d.e((a) this.f20563a.build());
    }

    public synchronized e h(int i10) throws GeneralSecurityException {
        int i11 = 0;
        while (i11 < this.f20563a.t()) {
            a.c s10 = this.f20563a.s(i11);
            if (s10.I() != i10) {
                i11++;
            } else if (s10.K().equals(KeyStatusType.ENABLED)) {
                this.f20563a.v(i10);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i10);
            }
        }
        throw new GeneralSecurityException("key not found: " + i10);
        return this;
    }
}
