package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public abstract class e<K, V> {
    private final Map zza = new HashMap();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract V create(@NonNull K k10);

    @NonNull
    public V get(@NonNull K k10) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k10)) {
                V v10 = this.zza.get(k10);
                return v10;
            }
            V create = create(k10);
            this.zza.put(k10, create);
            return create;
        }
    }
}
