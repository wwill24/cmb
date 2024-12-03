package com.google.android.recaptcha.internal;

import org.apache.commons.beanutils.PropertyUtils;

public abstract class zzdp implements Iterable {
    private final zzde zza = zzde.zza();

    protected zzdp() {
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        for (Object append : this) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(append);
            z10 = false;
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }
}
