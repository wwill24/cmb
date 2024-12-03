package com.coffeemeetsbagel.new_user_experience.birthday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.r0;

public final class a extends b6.c<i, c> {

    /* renamed from: com.coffeemeetsbagel.new_user_experience.birthday.a$a  reason: collision with other inner class name */
    public interface C0416a extends j<BirthdayInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f34914a;

        /* renamed from: b  reason: collision with root package name */
        private final BirthdayInteractor f34915b;

        public b(ViewGroup viewGroup, BirthdayInteractor birthdayInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "birthdayView");
            kotlin.jvm.internal.j.g(birthdayInteractor, "interactor");
            this.f34914a = viewGroup;
            this.f34915b = birthdayInteractor;
        }

        public final BirthdayPresenter a() {
            return new BirthdayPresenter(this.f34914a, this.f34915b);
        }
    }

    public interface c {
        ProfileManager V();

        na.b j();

        r0 v0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final i b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        BirthdayInteractor birthdayInteractor = new BirthdayInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_birthday, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        C0416a b10 = k.a().a(new b(viewGroup2, birthdayInteractor)).c((c) a()).b();
        kotlin.jvm.internal.j.f(b10, "component");
        return new i(viewGroup2, b10, birthdayInteractor);
    }
}
