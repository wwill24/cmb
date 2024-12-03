package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.a;
import hg.z;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f20581a = Charset.forName("UTF-8");

    public static z.c a(a.c cVar) {
        return (z.c) z.c.I().u(cVar.H().I()).t(cVar.K()).s(cVar.J()).r(cVar.I()).build();
    }

    public static z b(a aVar) {
        z.b s10 = z.I().s(aVar.K());
        for (a.c a10 : aVar.J()) {
            s10.r(a(a10));
        }
        return (z) s10.build();
    }

    public static void c(a.c cVar) throws GeneralSecurityException {
        if (!cVar.L()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(cVar.I())}));
        } else if (cVar.J() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(cVar.I())}));
        } else if (cVar.K() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(cVar.I())}));
        }
    }

    public static void d(a aVar) throws GeneralSecurityException {
        int K = aVar.K();
        boolean z10 = true;
        int i10 = 0;
        boolean z11 = false;
        for (a.c next : aVar.J()) {
            if (next.K() == KeyStatusType.ENABLED) {
                c(next);
                if (next.I() == K) {
                    if (!z11) {
                        z11 = true;
                    } else {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                }
                if (next.H().H() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z10 = false;
                }
                i10++;
            }
        }
        if (i10 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z11 && !z10) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
