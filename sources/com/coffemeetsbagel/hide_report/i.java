package com.coffemeetsbagel.hide_report;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.c;
import b6.j;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;

public final class i extends c<w, h> {

    public interface a extends j<HideReportMainInteractor>, h {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final rc.a f37675a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f37676b;

        /* renamed from: c  reason: collision with root package name */
        private final c0 f37677c;

        public b(rc.a aVar, boolean z10, c0 c0Var) {
            kotlin.jvm.internal.j.g(aVar, "binding");
            kotlin.jvm.internal.j.g(c0Var, "listener");
            this.f37675a = aVar;
            this.f37676b = z10;
            this.f37677c = c0Var;
        }

        public final a a(ProfileRepository profileRepository) {
            kotlin.jvm.internal.j.g(profileRepository, "profileRepository");
            return new a(profileRepository);
        }

        public final HideReportMainPresenter b() {
            return new HideReportMainPresenter(this.f37675a, this.f37676b, this.f37677c);
        }

        public final b0 c(ProfileRepository profileRepository) {
            kotlin.jvm.internal.j.g(profileRepository, "profileRepository");
            return new b0(profileRepository);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(h hVar) {
        super(hVar);
        kotlin.jvm.internal.j.g(hVar, "dependency");
    }

    public final w b(ViewGroup viewGroup, boolean z10, boolean z11, String str, String str2, String str3, String str4) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(str3, "source");
        kotlin.jvm.internal.j.g(str4, "matchType");
        HideReportMainInteractor hideReportMainInteractor = new HideReportMainInteractor(z10, z11, str, str2, str3, str4);
        rc.a c10 = rc.a.c(LayoutInflater.from(((h) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = d.a().c(new b(c10, z10, hideReportMainInteractor)).b((h) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new w(c10, a10, hideReportMainInteractor);
    }
}
