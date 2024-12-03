package vd;

import android.os.Bundle;
import androidx.annotation.NonNull;
import ce.f;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.p002authapi.zbl;
import xd.b;

public final class a {
    @NonNull
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<c> f42078a = b.f42094a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<C0509a> f42079b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<GoogleSignInOptions> f42080c;
    @NonNull
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final ae.a f42081d = b.f42095b;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final b f42082e = new zbl();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final be.a f42083f = new f();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public static final a.g f42084g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public static final a.g f42085h;

    /* renamed from: i  reason: collision with root package name */
    private static final a.C0480a f42086i;

    /* renamed from: j  reason: collision with root package name */
    private static final a.C0480a f42087j;

    @Deprecated
    /* renamed from: vd.a$a  reason: collision with other inner class name */
    public static class C0509a implements a.d {
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public static final C0509a f42088d = new C0509a(new C0510a());
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f42089a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f42090b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f42091c;

        @Deprecated
        /* renamed from: vd.a$a$a  reason: collision with other inner class name */
        public static class C0510a {
            @NonNull

            /* renamed from: a  reason: collision with root package name */
            protected Boolean f42092a = Boolean.FALSE;

            /* renamed from: b  reason: collision with root package name */
            protected String f42093b;

            public C0510a() {
            }

            @NonNull
            public final C0510a a(@NonNull String str) {
                this.f42093b = str;
                return this;
            }

            public C0510a(@NonNull C0509a aVar) {
                String unused = aVar.f42089a;
                this.f42092a = Boolean.valueOf(aVar.f42090b);
                this.f42093b = aVar.f42091c;
            }
        }

        public C0509a(@NonNull C0510a aVar) {
            this.f42090b = aVar.f42092a.booleanValue();
            this.f42091c = aVar.f42093b;
        }

        @NonNull
        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", (String) null);
            bundle.putBoolean("force_save_dialog", this.f42090b);
            bundle.putString("log_session_id", this.f42091c);
            return bundle;
        }

        public final String d() {
            return this.f42091c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0509a)) {
                return false;
            }
            C0509a aVar = (C0509a) obj;
            String str = aVar.f42089a;
            if (!n.b((Object) null, (Object) null) || this.f42090b != aVar.f42090b || !n.b(this.f42091c, aVar.f42091c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return n.c(null, Boolean.valueOf(this.f42090b), this.f42091c);
        }
    }

    static {
        a.g gVar = new a.g();
        f42084g = gVar;
        a.g gVar2 = new a.g();
        f42085h = gVar2;
        d dVar = new d();
        f42086i = dVar;
        e eVar = new e();
        f42087j = eVar;
        f42079b = new com.google.android.gms.common.api.a<>("Auth.CREDENTIALS_API", dVar, gVar);
        f42080c = new com.google.android.gms.common.api.a<>("Auth.GOOGLE_SIGN_IN_API", eVar, gVar2);
    }
}
