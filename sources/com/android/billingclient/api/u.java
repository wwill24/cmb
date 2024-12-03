package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final String f9009a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f9010a;

        /* synthetic */ a(h1 h1Var) {
        }

        @NonNull
        public u a() {
            if (this.f9010a != null) {
                return new u(this, (i1) null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f9010a = str;
            return this;
        }
    }

    /* synthetic */ u(a aVar, i1 i1Var) {
        this.f9009a = aVar.f9010a;
    }

    @NonNull
    public static a a() {
        return new a((h1) null);
    }

    @NonNull
    public final String b() {
        return this.f9009a;
    }
}
