package com.google.android.gms.internal.measurement;

final class zzhu extends zzib {
    zzhu(zzhy zzhy, String str, Long l10, boolean z10) {
        super(zzhy, str, l10, true, (zzia) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String str = this.zzb;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid long value for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append((String) obj);
            return null;
        }
    }
}
