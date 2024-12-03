package fa;

import com.coffeemeetsbagel.logging.CmbBuildConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import ga.d;
import io.sentry.n2;
import io.sentry.protocol.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0491a f40771d = new C0491a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f40772e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CmbBuildConfig f40773a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f40774b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public FirebaseCrashlytics f40775c;

    /* renamed from: fa.a$a  reason: collision with other inner class name */
    public static final class C0491a {
        private C0491a() {
        }

        public /* synthetic */ C0491a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean e() {
            CmbBuildConfig cmbBuildConfig;
            CmbBuildConfig cmbBuildConfig2 = CmbBuildConfig.DEBUG;
            a c10 = a.f40772e;
            CmbBuildConfig cmbBuildConfig3 = null;
            if (c10 != null) {
                cmbBuildConfig = c10.f40773a;
            } else {
                cmbBuildConfig = null;
            }
            if (cmbBuildConfig2 != cmbBuildConfig) {
                CmbBuildConfig cmbBuildConfig4 = CmbBuildConfig.SUPERUSER;
                a c11 = a.f40772e;
                if (c11 != null) {
                    cmbBuildConfig3 = c11.f40773a;
                }
                if (cmbBuildConfig4 == cmbBuildConfig3) {
                    return true;
                }
                return false;
            }
            return true;
        }

        private final void k() {
            if (a.f40772e == null) {
                a.f40772e = new a((CmbBuildConfig) null, (d) null, (FirebaseCrashlytics) null, (DefaultConstructorMarker) null);
            }
        }

        private final void m(String str, String str2) {
            CmbBuildConfig cmbBuildConfig;
            CmbBuildConfig cmbBuildConfig2 = CmbBuildConfig.SUPERUSER;
            a c10 = a.f40772e;
            if (c10 != null) {
                cmbBuildConfig = c10.f40773a;
            } else {
                cmbBuildConfig = null;
            }
            if (cmbBuildConfig2 == cmbBuildConfig) {
                a c11 = a.f40772e;
                j.d(c11);
                if (c11.f40774b != null) {
                    a c12 = a.f40772e;
                    j.d(c12);
                    d d10 = c12.f40774b;
                    j.d(d10);
                    d10.a(str, str2);
                }
            }
        }

        private final void n(String str, boolean z10, String str2) {
            CmbBuildConfig cmbBuildConfig;
            CmbBuildConfig cmbBuildConfig2 = CmbBuildConfig.SUPERUSER;
            a c10 = a.f40772e;
            if (c10 != null) {
                cmbBuildConfig = c10.f40773a;
            } else {
                cmbBuildConfig = null;
            }
            if (cmbBuildConfig2 == cmbBuildConfig) {
                a c11 = a.f40772e;
                j.d(c11);
                if (c11.f40774b != null) {
                    a c12 = a.f40772e;
                    j.d(c12);
                    d d10 = c12.f40774b;
                    j.d(d10);
                    d10.b(str, z10, str2);
                }
            }
        }

        public final void a(String str, String str2) {
            j.g(str, "tag");
            j.g(str2, "message");
            k();
            e();
            m(str, str2);
        }

        public final void b(String str, String str2) {
            j.g(str, "tag");
            j.g(str2, "message");
            k();
            e();
            m(str, str2);
        }

        public final void c(String str, String str2, Throwable th2) {
            FirebaseCrashlytics b10;
            j.g(str, "tag");
            j.g(str2, "message");
            j.g(th2, "throwable");
            k();
            e();
            a c10 = a.f40772e;
            if (!(c10 == null || (b10 = c10.f40775c) == null)) {
                b10.log(str2);
                b10.recordException(th2);
            }
            n2.e(th2);
            m(str, str2);
        }

        public final void d(CmbBuildConfig cmbBuildConfig, d dVar, FirebaseCrashlytics firebaseCrashlytics) {
            j.g(cmbBuildConfig, "buildConfig");
            j.g(dVar, "rlcsManager");
            j.g(firebaseCrashlytics, "crashlytics");
            if (a.f40772e != null) {
                a c10 = a.f40772e;
                j.d(c10);
                if (c10.f40773a != null) {
                    return;
                }
            }
            a.f40772e = new a(cmbBuildConfig, dVar, firebaseCrashlytics, (DefaultConstructorMarker) null);
        }

        public final void f(Throwable th2) {
            FirebaseCrashlytics b10;
            j.g(th2, "throwable");
            k();
            e();
            a c10 = a.f40772e;
            if (!(c10 == null || (b10 = c10.f40775c) == null)) {
                b10.recordException(th2);
            }
            n2.e(th2);
        }

        public final void g(String str, String str2) {
            j.g(str, "tag");
            j.g(str2, "message");
            k();
            e();
            n(str, false, str2);
        }

        public final void h(String str, String str2) {
            j.g(str, "tag");
            j.g(str2, "message");
            k();
            e();
            n(str, true, str2);
        }

        public final void i(String str, String str2) {
            FirebaseCrashlytics b10;
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(str2, "value");
            a c10 = a.f40772e;
            if (!(c10 == null || (b10 = c10.f40775c) == null)) {
                b10.setCustomKey(str, str2);
            }
            n2.q(str, str2);
        }

        public final void j(String str) {
            FirebaseCrashlytics b10;
            if (str != null) {
                a c10 = a.f40772e;
                if (!(c10 == null || (b10 = c10.f40775c) == null)) {
                    b10.setUserId(str);
                }
                x xVar = new x();
                xVar.s(str);
                n2.r(xVar);
            }
        }

        public final void l(String str, String str2) {
            j.g(str, "tag");
            j.g(str2, "message");
            k();
            e();
            m(str, str2);
        }
    }

    private a(CmbBuildConfig cmbBuildConfig, d dVar, FirebaseCrashlytics firebaseCrashlytics) {
        this.f40773a = cmbBuildConfig;
        this.f40774b = dVar;
        this.f40775c = firebaseCrashlytics;
    }

    public /* synthetic */ a(CmbBuildConfig cmbBuildConfig, d dVar, FirebaseCrashlytics firebaseCrashlytics, DefaultConstructorMarker defaultConstructorMarker) {
        this(cmbBuildConfig, dVar, firebaseCrashlytics);
    }

    public static final void f(String str, String str2) {
        f40771d.b(str, str2);
    }

    public static final void g(String str, String str2, Throwable th2) {
        f40771d.c(str, str2, th2);
    }

    public static final void h(CmbBuildConfig cmbBuildConfig, d dVar, FirebaseCrashlytics firebaseCrashlytics) {
        f40771d.d(cmbBuildConfig, dVar, firebaseCrashlytics);
    }

    public static final void i(Throwable th2) {
        f40771d.f(th2);
    }

    public static final void j(String str, String str2) {
        f40771d.g(str, str2);
    }

    public static final void k(String str, String str2) {
        f40771d.h(str, str2);
    }

    public static final void l(String str) {
        f40771d.j(str);
    }
}
