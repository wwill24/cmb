package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

public final class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f8939a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f8940b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f8941a;

        /* renamed from: b  reason: collision with root package name */
        private String f8942b = "";

        /* synthetic */ a(t0 t0Var) {
        }

        @NonNull
        public i a() {
            i iVar = new i();
            iVar.f8939a = this.f8941a;
            iVar.f8940b = this.f8942b;
            return iVar;
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f8942b = str;
            return this;
        }

        @NonNull
        public a c(int i10) {
            this.f8941a = i10;
            return this;
        }
    }

    @NonNull
    public static a c() {
        return new a((t0) null);
    }

    @NonNull
    public String a() {
        return this.f8940b;
    }

    public int b() {
        return this.f8939a;
    }

    @NonNull
    public String toString() {
        String zzg = zzb.zzg(this.f8939a);
        String str = this.f8940b;
        return "Response Code: " + zzg + ", Debug Message: " + str;
    }
}
