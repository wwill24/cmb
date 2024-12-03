package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzab  reason: invalid package */
public final class zzab {
    /* access modifiers changed from: private */
    public final zzj zza;
    private final zzaa zzb;

    private zzab(zzaa zzaa) {
        zzi zzi = zzi.zza;
        this.zzb = zzaa;
        this.zza = zzi;
    }

    public static zzab zzb(zzj zzj) {
        return new zzab(new zzw(zzj));
    }

    public static zzab zzc(String str) {
        zzp zzp = new zzp(Pattern.compile("[.-]"));
        if (!((zzo) zzp.zza("")).zza.matches()) {
            return new zzab(new zzy(zzp));
        }
        throw new IllegalArgumentException(zzac.zzb("The pattern may not match the empty string: %s", zzp));
    }

    public final List zzd(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zza2 = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add((String) zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
