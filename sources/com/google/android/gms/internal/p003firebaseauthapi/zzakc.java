package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakc  reason: invalid package */
final class zzakc {
    private static final zzakc zzb = new zzakc(true);
    final zzamo zza = new zzame(16);
    private boolean zzc;
    private boolean zzd;

    private zzakc() {
    }

    public static zzakc zza() {
        throw null;
    }

    private static final void zzd(zzakb zzakb, Object obj) {
        boolean z10;
        zzanl zzb2 = zzakb.zzb();
        byte[] bArr = zzakq.zzd;
        obj.getClass();
        zzanl zzanl = zzanl.DOUBLE;
        zzanm zzanm = zzanm.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z10 = obj instanceof Integer;
                break;
            case 1:
                z10 = obj instanceof Long;
                break;
            case 2:
                z10 = obj instanceof Float;
                break;
            case 3:
                z10 = obj instanceof Double;
                break;
            case 4:
                z10 = obj instanceof Boolean;
                break;
            case 5:
                z10 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzajf) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzakm)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzalp) || (obj instanceof zzaku)) {
                    return;
                }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzakb.zza()), zzakb.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzakc zzakc = new zzakc();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry zzg = this.zza.zzg(i10);
            zzakc.zzc((zzakb) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzakc.zzc((zzakb) entry.getKey(), entry.getValue());
        }
        zzakc.zzd = this.zzd;
        return zzakc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzakc)) {
            return false;
        }
        return this.zza.equals(((zzakc) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
                Map.Entry zzg = this.zza.zzg(i10);
                if (zzg.getValue() instanceof zzakk) {
                    ((zzakk) zzg.getValue()).zzF();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzakb zzakb, Object obj) {
        if (!zzakb.zzc()) {
            zzd(zzakb, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zzd(zzakb, arrayList.get(i10));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzaku) {
            this.zzd = true;
        }
        this.zza.put(zzakb, obj);
    }

    private zzakc(boolean z10) {
        zzb();
        zzb();
    }
}
