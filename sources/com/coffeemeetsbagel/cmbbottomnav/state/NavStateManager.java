package com.coffeemeetsbagel.cmbbottomnav.state;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.internal.j;
import qj.q;
import v5.d;
import y5.a;
import y5.b;

public final class NavStateManager implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Optional<Integer>> f11533a;

    public enum NavState {
        SUGGESTED(d.bottom_nav_item_bagels),
        DISCOVER(d.bottom_nav_item_discover),
        CHAT(d.bottom_nav_item_chat),
        LIKES_YOU(d.bottom_nav_item_limelight),
        ME_PROFILE(d.bottom_nav_item_badge_profile);
        
        private final int resId;

        private NavState(int i10) {
            this.resId = i10;
        }

        public final int b() {
            return this.resId;
        }
    }

    public NavStateManager() {
        com.jakewharton.rxrelay2.b<Optional<Integer>> D0 = com.jakewharton.rxrelay2.b.D0(Optional.a());
        j.f(D0, "createDefault(Optional.absent<Int>())");
        this.f11533a = D0;
    }

    public q<Optional<Integer>> a() {
        q<Optional<Integer>> s10 = this.f11533a.P().s();
        j.f(s10, "selectedRelay.hide()\n      .distinctUntilChanged()");
        return s10;
    }

    public void b(Integer num) {
        this.f11533a.accept(Optional.b(num));
    }

    public final void c(NavState navState) {
        j.g(navState, "navState");
        this.f11533a.accept(Optional.e(Integer.valueOf(navState.b())));
    }
}
