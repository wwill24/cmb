package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import k6.e;

public final class a extends b6.c<l, c> {

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.age.a$a  reason: collision with other inner class name */
    public interface C0425a extends j<AgeMatchPreferenceInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final e f35182a;

        public b(e eVar) {
            kotlin.jvm.internal.j.g(eVar, "binding");
            this.f35182a = eVar;
        }

        public final k a() {
            return new k(this.f35182a);
        }
    }

    public interface c {
        SaveAgePreferenceUseCase X();

        d<?, ?> a();

        s9.a b();

        LoadAgePreferenceUseCase b0();

        l j();

        k k();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        AgeMatchPreferenceInteractor ageMatchPreferenceInteractor = new AgeMatchPreferenceInteractor();
        e c10 = e.c(LayoutInflater.from(((c) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        C0425a b10 = n.a().a(new b(c10)).c((c) a()).b();
        ConstraintLayout b11 = c10.getRoot();
        kotlin.jvm.internal.j.f(b11, "binding.root");
        kotlin.jvm.internal.j.f(b10, "component");
        return new l(b11, b10, ageMatchPreferenceInteractor);
    }
}
