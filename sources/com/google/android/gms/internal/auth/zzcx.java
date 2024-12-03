package com.google.android.gms.internal.auth;

final class zzcx extends zzdc {
    zzcx(zzcz zzcz, String str, Double d10, boolean z10) {
        super(zzcz, str, d10, true, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid double value for ");
            sb2.append(zzc);
            sb2.append(": ");
            sb2.append((String) obj);
            return null;
        }
    }
}
