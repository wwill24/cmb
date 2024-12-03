package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

public abstract class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f8878a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f8879b;

        /* renamed from: c  reason: collision with root package name */
        private volatile s f8880c;

        /* renamed from: d  reason: collision with root package name */
        private volatile c f8881d;

        /* synthetic */ a(Context context, p1 p1Var) {
            this.f8879b = context;
        }

        @NonNull
        public e a() {
            if (this.f8879b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else if (this.f8880c == null) {
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            } else if (!this.f8878a) {
                throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
            } else if (this.f8880c == null && this.f8881d != null) {
                throw new IllegalArgumentException("Please provide a valid listener for Google Play Billing purchases updates when enabling Alternative Billing.");
            } else if (this.f8880c != null) {
                return new f((String) null, this.f8878a, false, this.f8879b, this.f8880c, this.f8881d);
            } else {
                return new f((String) null, this.f8878a, this.f8879b, (x0) null);
            }
        }

        @NonNull
        public a b() {
            this.f8878a = true;
            return this;
        }

        @NonNull
        public a c(@NonNull s sVar) {
            this.f8880c = sVar;
            return this;
        }
    }

    @NonNull
    public static a f(@NonNull Context context) {
        return new a(context, (p1) null);
    }

    public abstract void a(@NonNull a aVar, @NonNull b bVar);

    public abstract void b(@NonNull j jVar, @NonNull k kVar);

    public abstract int c();

    public abstract boolean d();

    @NonNull
    public abstract i e(@NonNull Activity activity, @NonNull h hVar);

    public abstract void g(@NonNull t tVar, @NonNull p pVar);

    public abstract void h(@NonNull u uVar, @NonNull q qVar);

    public abstract void i(@NonNull v vVar, @NonNull r rVar);

    public abstract void j(@NonNull g gVar);
}
