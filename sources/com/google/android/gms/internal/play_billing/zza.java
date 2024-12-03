package com.google.android.gms.internal.play_billing;

import com.google.firebase.database.DatabaseError;

enum zza {
    RESPONSE_CODE_UNSPECIFIED(DatabaseError.UNKNOWN_ERROR),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    zze(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);
    
    private static final zzx zzp = null;
    private final int zzr;

    static {
        int i10;
        zzw zzw = new zzw();
        for (zza zza : values()) {
            zzw.zza(Integer.valueOf(zza.zzr), zza);
        }
        zzp = zzw.zzb();
    }

    private zza(int i10) {
        this.zzr = i10;
    }

    static zza zza(int i10) {
        zzx zzx = zzp;
        Integer valueOf = Integer.valueOf(i10);
        if (!zzx.containsKey(valueOf)) {
            return RESPONSE_CODE_UNSPECIFIED;
        }
        return (zza) zzx.get(valueOf);
    }
}
