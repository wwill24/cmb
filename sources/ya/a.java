package ya;

import gk.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0513a f42160b = new C0513a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f42161a;

    /* renamed from: ya.a$a  reason: collision with other inner class name */
    public static final class C0513a {
        private C0513a() {
        }

        public /* synthetic */ C0513a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(a7.a aVar) {
        j.g(aVar, "analyticsManager");
        this.f42161a = aVar;
    }

    public final void a() {
        this.f42161a.d("Profile Prompt Selector Viewed");
    }

    public final void b(String str) {
        j.g(str, "id");
        this.f42161a.trackEvent("Profile Prompt Selector - Prompt Tapped", g0.f(h.a("question_id", str)));
    }

    public final void c() {
        this.f42161a.f("Profile Prompt Selector");
    }
}
