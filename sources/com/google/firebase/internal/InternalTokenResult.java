package com.google.firebase.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;

public class InternalTokenResult {
    private String zza;

    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalTokenResult)) {
            return false;
        }
        return n.b(this.zza, ((InternalTokenResult) obj).zza);
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return n.c(this.zza);
    }

    @NonNull
    public String toString() {
        return n.d(this).a("token", this.zza).toString();
    }
}
