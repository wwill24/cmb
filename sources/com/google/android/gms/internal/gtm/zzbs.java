package com.google.android.gms.internal.gtm;

public abstract class zzbs extends zzbr {
    private boolean zza;

    protected zzbs(zzbv zzbv) {
        super(zzbv);
    }

    /* access modifiers changed from: protected */
    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        zzd();
        this.zza = true;
    }

    public final boolean zzY() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public abstract void zzd();
}
