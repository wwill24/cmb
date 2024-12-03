package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

abstract class zzbf implements Map.Entry {
    zzbf() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (!zzam.zza(getKey(), entry.getKey()) || !zzam.zza(getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract Object getKey();

    public abstract Object getValue();

    public final int hashCode() {
        int i10;
        Object key = getKey();
        Object value = getValue();
        int i11 = 0;
        if (key == null) {
            i10 = 0;
        } else {
            i10 = key.hashCode();
        }
        if (value != null) {
            i11 = value.hashCode();
        }
        return i10 ^ i11;
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        return valueOf + "=" + valueOf2;
    }
}
