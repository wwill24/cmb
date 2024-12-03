package com.withpersona.sdk2.inquiry.permissions;

import android.view.ViewGroup;
import android.widget.Button;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pi.b;

final class BottomSheetDialogView$viewFactory$2$8 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $this_bind;
    final /* synthetic */ BottomSheetDialogView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetDialogView$viewFactory$2$8(b bVar, BottomSheetDialogView bottomSheetDialogView) {
        super(0);
        this.$this_bind = bVar;
        this.this$0 = bottomSheetDialogView;
    }

    public final void invoke() {
        boolean z10 = false;
        if (this.$this_bind.f33760e.getLineCount() > 1 || this.$this_bind.f33761f.getLineCount() > 1) {
            Button button = this.$this_bind.f33760e;
            j.f(button, "negativeButton");
            b bVar = this.$this_bind;
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = bVar.f33758c.getWidth();
                button.setLayoutParams(layoutParams);
                Button button2 = this.$this_bind.f33761f;
                j.f(button2, "positiveButton");
                b bVar2 = this.$this_bind;
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = bVar2.f33758c.getWidth();
                    button2.setLayoutParams(layoutParams2);
                    b bVar3 = this.$this_bind;
                    bVar3.f33758c.setReferencedIds(new int[]{bVar3.f33761f.getId(), this.$this_bind.f33760e.getId()});
                    z10 = true;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        BottomSheetDialogView bottomSheetDialogView = this.this$0;
        StepStyle h10 = bottomSheetDialogView.f27080d;
        b bVar4 = this.$this_bind;
        j.f(bVar4, "this");
        bottomSheetDialogView.j(h10, bVar4, z10);
    }
}
