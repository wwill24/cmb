package com.google.android.gms.internal.gtm;

import rd.c;

final class zzcu implements c {
    private int zza = 2;
    private boolean zzb;

    zzcu() {
    }

    public final void error(Exception exc) {
    }

    public final void error(String str) {
    }

    public final int getLogLevel() {
        return this.zza;
    }

    public final void info(String str) {
    }

    public final void setLogLevel(int i10) {
        this.zza = i10;
        if (!this.zzb) {
            zzet<String> zzet = zzeu.zzc;
            String zzb2 = zzet.zzb();
            String zzb3 = zzet.zzb();
            StringBuilder sb2 = new StringBuilder(zzb3.length() + 91);
            sb2.append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            sb2.append(zzb3);
            sb2.append(" DEBUG");
            this.zzb = true;
        }
    }

    public final void verbose(String str) {
    }

    public final void warn(String str) {
    }
}
