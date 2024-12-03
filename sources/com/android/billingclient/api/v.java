package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final String f9038a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f9039a;

        /* synthetic */ a(j1 j1Var) {
        }

        @NonNull
        public v a() {
            if (this.f9039a != null) {
                return new v(this, (k1) null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f9039a = str;
            return this;
        }
    }

    /* synthetic */ v(a aVar, k1 k1Var) {
        this.f9038a = aVar.f9039a;
    }

    @NonNull
    public static a a() {
        return new a((j1) null);
    }

    @NonNull
    public final String b() {
        return this.f9038a;
    }
}
