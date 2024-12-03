package com.coffeemeetsbagel.feature.likepassflow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;

public class LikePassFlowAdapter extends x {

    /* renamed from: h  reason: collision with root package name */
    private b f13042h;

    /* renamed from: i  reason: collision with root package name */
    private int f13043i;

    public enum LikePassFlowType {
        LIKE_FLOW_FIRST,
        PASS_FLOW_FIRST,
        ONBOARDING_FLOW,
        POST_ONBOARDING_FLOW
    }

    public LikePassFlowAdapter(FragmentManager fragmentManager, b bVar) {
        super(fragmentManager);
        this.f13042h = bVar;
    }

    public int e() {
        return this.f13042h.e();
    }

    public int f(Object obj) {
        for (int i10 = 0; i10 < e(); i10++) {
            if (y(i10, (Fragment) obj)) {
                return i10;
            }
        }
        return -2;
    }

    public Fragment u(int i10) {
        return this.f13042h.a(i10);
    }

    public long v(int i10) {
        return this.f13042h.b(i10);
    }

    public int x() {
        return this.f13043i;
    }

    /* access modifiers changed from: package-private */
    public boolean y(int i10, Fragment fragment) {
        return this.f13042h.c(i10, fragment);
    }

    public void z(int i10) {
        this.f13043i = i10;
    }
}
