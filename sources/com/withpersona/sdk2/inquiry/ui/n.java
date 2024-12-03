package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SignatureBottomSheetController f29400a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f29401b;

    public /* synthetic */ n(SignatureBottomSheetController signatureBottomSheetController, BottomSheetBehavior bottomSheetBehavior) {
        this.f29400a = signatureBottomSheetController;
        this.f29401b = bottomSheetBehavior;
    }

    public final void onClick(View view) {
        SignatureBottomSheetController.q(this.f29400a, this.f29401b, view);
    }
}
