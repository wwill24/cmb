package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;

public final class zzrw {
    private final List<zzro> zza;
    private final List<zzro> zzb;
    private final List<zzro> zzc;
    private final List<zzro> zzd;
    private final List<zzro> zze;
    private final List<zzro> zzf;
    private final List<String> zzg;
    private final List<String> zzh;
    private final List<String> zzi;
    private final List<String> zzj;

    /* synthetic */ zzrw(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, zzrv zzrv) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableList(list2);
        this.zzc = Collections.unmodifiableList(list3);
        this.zzd = Collections.unmodifiableList(list4);
        this.zze = Collections.unmodifiableList(list5);
        this.zzf = Collections.unmodifiableList(list6);
        this.zzg = Collections.unmodifiableList(list7);
        this.zzh = Collections.unmodifiableList(list8);
        this.zzi = Collections.unmodifiableList(list9);
        this.zzj = Collections.unmodifiableList(list10);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        String valueOf3 = String.valueOf(this.zzc);
        String valueOf4 = String.valueOf(this.zzd);
        String valueOf5 = String.valueOf(this.zze);
        String valueOf6 = String.valueOf(this.zzf);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        int length3 = valueOf3.length();
        int length4 = valueOf4.length();
        StringBuilder sb2 = new StringBuilder(length + 102 + length2 + length3 + length4 + valueOf5.length() + valueOf6.length());
        sb2.append("Positive predicates: ");
        sb2.append(valueOf);
        sb2.append("  Negative predicates: ");
        sb2.append(valueOf2);
        sb2.append("  Add tags: ");
        sb2.append(valueOf3);
        sb2.append("  Remove tags: ");
        sb2.append(valueOf4);
        sb2.append("  Add macros: ");
        sb2.append(valueOf5);
        sb2.append("  Remove macros: ");
        sb2.append(valueOf6);
        return sb2.toString();
    }

    public final List<zzro> zza() {
        return this.zze;
    }

    public final List<String> zzb() {
        return this.zzi;
    }

    public final List<zzro> zzc() {
        return this.zzc;
    }

    public final List<zzro> zzd() {
        return this.zzb;
    }

    public final List<zzro> zze() {
        return this.zza;
    }

    public final List<zzro> zzf() {
        return this.zzf;
    }

    public final List<String> zzg() {
        return this.zzj;
    }

    public final List<zzro> zzh() {
        return this.zzd;
    }
}
