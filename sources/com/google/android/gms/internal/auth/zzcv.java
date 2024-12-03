package com.google.android.gms.internal.auth;

final class zzcv extends zzdc {
    zzcv(zzcz zzcz, String str, Long l10, boolean z10) {
        super(zzcz, str, l10, true, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid long value for ");
            sb2.append(zzc);
            sb2.append(": ");
            sb2.append((String) obj);
            return null;
        }
    }
}
