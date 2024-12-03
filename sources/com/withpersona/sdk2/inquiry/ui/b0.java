package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public final /* synthetic */ class b0 implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f29382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f29383c;

    public /* synthetic */ b0(UiScreenRunner uiScreenRunner, View view, BottomSheetBehavior bottomSheetBehavior) {
        this.f29381a = uiScreenRunner;
        this.f29382b = view;
        this.f29383c = bottomSheetBehavior;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        UiScreenRunner.B(this.f29381a, this.f29382b, this.f29383c, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
