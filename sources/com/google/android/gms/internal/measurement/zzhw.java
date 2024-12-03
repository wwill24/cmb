package com.google.android.gms.internal.measurement;

final class zzhw extends zzib {
    zzhw(zzhy zzhy, String str, Double d10, boolean z10) {
        super(zzhy, "measurement.test.double_flag", d10, true, (zzia) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String str = this.zzb;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid double value for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append((String) obj);
            return null;
        }
    }
}
