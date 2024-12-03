package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public final /* synthetic */ class r implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f29524b;

    public /* synthetic */ r(UiScreenRunner uiScreenRunner, BottomSheetBehavior bottomSheetBehavior) {
        this.f29523a = uiScreenRunner;
        this.f29524b = bottomSheetBehavior;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        UiScreenRunner.C(this.f29523a, this.f29524b, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
