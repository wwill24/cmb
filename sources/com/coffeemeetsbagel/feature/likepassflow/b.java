package com.coffeemeetsbagel.feature.likepassflow;

import androidx.fragment.app.Fragment;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private c f13051a;

    b(c cVar) {
        this.f13051a = cVar;
    }

    public Fragment a(int i10) {
        return this.f13051a.x(i10);
    }

    public long b(int i10) {
        return this.f13051a.y(i10);
    }

    public boolean c(int i10, Fragment fragment) {
        return this.f13051a.z(i10, fragment);
    }

    public void d() {
        for (int i10 = 0; i10 < this.f13051a.Y(); i10++) {
            if (this.f13051a.A(i10)) {
                this.f13051a.X(i10);
            }
        }
        this.f13051a.Z();
    }

    public int e() {
        return this.f13051a.Y();
    }
}
