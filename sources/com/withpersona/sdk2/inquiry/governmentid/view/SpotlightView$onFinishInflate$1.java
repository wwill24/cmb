package com.withpersona.sdk2.inquiry.governmentid.view;

import android.view.View;
import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SpotlightView$onFinishInflate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SpotlightView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpotlightView$onFinishInflate$1(SpotlightView spotlightView) {
        super(0);
        this.this$0 = spotlightView;
    }

    /* access modifiers changed from: private */
    public static final void c(SpotlightView spotlightView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        j.g(spotlightView, "this$0");
        spotlightView.d(i10, i11, i12, i13);
    }

    public final void invoke() {
        View findViewById;
        ViewParent parent = this.this$0.getParent();
        if ((parent instanceof View) && (findViewById = ((View) parent).findViewById(this.this$0.f26032a)) != null) {
            findViewById.addOnLayoutChangeListener(new c(this.this$0));
            this.this$0.d(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        }
    }
}
