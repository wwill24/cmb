package com.google.android.gms.internal.auth;

import android.util.Base64;
import java.io.IOException;

final class zzcy extends zzdc {
    final /* synthetic */ zzhu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcy(zzcz zzcz, String str, Object obj, boolean z10, zzhu zzhu, byte[] bArr) {
        super(zzcz, "getTokenRefactor__blocked_packages", obj, true, (zzdb) null);
        this.zza = zzhu;
    }

    /* access modifiers changed from: package-private */
    public final Object zza(Object obj) {
        try {
            return zzhr.zzk(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            String zzc = super.zzc();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid byte[] value for ");
            sb2.append(zzc);
            sb2.append(": ");
            sb2.append((String) obj);
            return null;
        }
    }
}
