package com.coffeemeetsbagel.new_user_experience.carousel;

import a7.a;
import b6.s;
import com.coffeemeetsbagel.new_user_experience.carousel.CarouselPresenter;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.j;
import na.b;

public final class c extends s<CarouselPresenter, i> implements CarouselPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f34935f;

    /* renamed from: g  reason: collision with root package name */
    public a f34936g;

    private final String J1(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "Unknown" : "Matches" : "Noon" : "Matchmaker";
    }

    public void B(int i10) {
        String format2 = String.format("Onboarding %s Intro - Next Tapped", Arrays.copyOf(new Object[]{J1(i10)}, 1));
        j.f(format2, "format(this, *args)");
        H1().d(format2);
    }

    public final a H1() {
        a aVar = this.f34936g;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final b I1() {
        b bVar = this.f34935f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public void J0(int i10) {
        String format2 = String.format("Onboarding %s Intro Page", Arrays.copyOf(new Object[]{J1(i10)}, 1));
        j.f(format2, "format(this, *args)");
        H1().g(format2);
    }

    public void L() {
        b.f(I1(), (Map) null, 1, (Object) null);
    }

    public void h1(int i10) {
        String format2 = String.format("Onboarding %s Intro - Hardware Back Button Tapped", Arrays.copyOf(new Object[]{J1(i10)}, 1));
        j.f(format2, "format(this, *args)");
        H1().d(format2);
    }
}
