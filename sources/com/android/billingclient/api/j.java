package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f8943a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8944a;

        /* synthetic */ a(v0 v0Var) {
        }

        @NonNull
        public j a() {
            String str = this.f8944a;
            if (str != null) {
                j jVar = new j((w0) null);
                jVar.f8943a = str;
                return jVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f8944a = str;
            return this;
        }
    }

    /* synthetic */ j(w0 w0Var) {
    }

    @NonNull
    public static a b() {
        return new a((v0) null);
    }

    @NonNull
    public String a() {
        return this.f8943a;
    }
}
