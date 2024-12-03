package vd;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.n;

public final class c implements a.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final c f42098b = new c(new Bundle(), (g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f42099a;

    /* synthetic */ c(Bundle bundle, g gVar) {
        this.f42099a = bundle;
    }

    @NonNull
    public final Bundle a() {
        return new Bundle(this.f42099a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return n.a(this.f42099a, ((c) obj).f42099a);
    }

    public final int hashCode() {
        return n.c(this.f42099a);
    }
}
