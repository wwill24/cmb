package com.google.android.recaptcha.internal;

import com.facebook.stetho.websocket.CloseCodes;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class zzl {
    public static final zzk zza = new zzk((DefaultConstructorMarker) null);
    public static final zzl zzb = new zzl(9999);
    public static final zzl zzc = new zzl(1000);
    public static final zzl zzd = new zzl(1001);
    public static final zzl zze = new zzl(CloseCodes.PROTOCOL_ERROR);
    public static final zzl zzf = new zzl(1003);
    public static final zzl zzg = new zzl(1004);
    public static final zzl zzh = new zzl(1005);
    public static final zzl zzi = new zzl(CloseCodes.CLOSED_ABNORMALLY);
    public static final zzl zzj = new zzl(1007);
    public static final zzl zzk = new zzl(1008);
    public static final zzl zzl = new zzl(1009);
    public static final zzl zzm = new zzl(1010);
    private final int zzn;

    private zzl(int i10) {
        this.zzn = i10;
    }

    public final int zza() {
        return this.zzn;
    }
}
