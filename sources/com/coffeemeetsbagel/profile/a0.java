package com.coffeemeetsbagel.profile;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class a0 implements NestedScrollView.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileView f36072a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f36073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rect f36074c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f36075d;

    public /* synthetic */ a0(ProfileView profileView, ViewGroup viewGroup, Rect rect, int i10) {
        this.f36072a = profileView;
        this.f36073b = viewGroup;
        this.f36074c = rect;
        this.f36075d = i10;
    }

    public final void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        this.f36072a.L(this.f36073b, this.f36074c, this.f36075d, nestedScrollView, i10, i11, i12, i13);
    }
}
