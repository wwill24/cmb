package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f8860a;

    /* renamed from: com.android.billingclient.api.a$a  reason: collision with other inner class name */
    public static final class C0107a {

        /* renamed from: a  reason: collision with root package name */
        private String f8861a;

        /* synthetic */ C0107a(w wVar) {
        }

        @NonNull
        public a a() {
            String str = this.f8861a;
            if (str != null) {
                a aVar = new a((r0) null);
                aVar.f8860a = str;
                return aVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        @NonNull
        public C0107a b(@NonNull String str) {
            this.f8861a = str;
            return this;
        }
    }

    /* synthetic */ a(r0 r0Var) {
    }

    @NonNull
    public static C0107a b() {
        return new C0107a((w) null);
    }

    @NonNull
    public String a() {
        return this.f8860a;
    }
}
