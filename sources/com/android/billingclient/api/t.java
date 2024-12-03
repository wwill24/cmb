package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.HashSet;
import java.util.List;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final zzu f9001a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public zzu f9002a;

        /* synthetic */ a(d1 d1Var) {
        }

        @NonNull
        public t a() {
            return new t(this, (g1) null);
        }

        @NonNull
        public a b(@NonNull List<b> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            for (b next : list) {
                if (!"play_pass_subs".equals(next.c())) {
                    hashSet.add(next.c());
                }
            }
            if (hashSet.size() <= 1) {
                this.f9002a = zzu.zzj(list);
                return this;
            }
            throw new IllegalArgumentException("All products should be of the same product type.");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f9003a;

        /* renamed from: b  reason: collision with root package name */
        private final String f9004b;

        public static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f9005a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f9006b;

            /* synthetic */ a(e1 e1Var) {
            }

            @NonNull
            public b a() {
                if ("first_party".equals(this.f9006b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                } else if (this.f9005a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                } else if (this.f9006b != null) {
                    return new b(this, (f1) null);
                } else {
                    throw new IllegalArgumentException("Product type must be provided.");
                }
            }

            @NonNull
            public a b(@NonNull String str) {
                this.f9005a = str;
                return this;
            }

            @NonNull
            public a c(@NonNull String str) {
                this.f9006b = str;
                return this;
            }
        }

        /* synthetic */ b(a aVar, f1 f1Var) {
            this.f9003a = aVar.f9005a;
            this.f9004b = aVar.f9006b;
        }

        @NonNull
        public static a a() {
            return new a((e1) null);
        }

        @NonNull
        public final String b() {
            return this.f9003a;
        }

        @NonNull
        public final String c() {
            return this.f9004b;
        }
    }

    /* synthetic */ t(a aVar, g1 g1Var) {
        this.f9001a = aVar.f9002a;
    }

    @NonNull
    public static a a() {
        return new a((d1) null);
    }

    public final zzu b() {
        return this.f9001a;
    }

    @NonNull
    public final String c() {
        return ((b) this.f9001a.get(0)).c();
    }
}
