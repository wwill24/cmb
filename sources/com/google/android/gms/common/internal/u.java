package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;

public class u implements a.d {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final u f39057b = a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f39058a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f39059a;

        /* synthetic */ a(x xVar) {
        }

        @NonNull
        public u a() {
            return new u(this.f39059a, (y) null);
        }

        @NonNull
        public a b(String str) {
            this.f39059a = str;
            return this;
        }
    }

    /* synthetic */ u(String str, y yVar) {
        this.f39058a = str;
    }

    @NonNull
    public static a a() {
        return new a((x) null);
    }

    @NonNull
    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f39058a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return n.b(this.f39058a, ((u) obj).f39058a);
    }

    public final int hashCode() {
        return n.c(this.f39058a);
    }
}
