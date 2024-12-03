package com.withpersona.sdk2.inquiry.modal;

import android.view.ViewGroup;
import android.widget.Button;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import oi.a;

final class CancelScreen$viewFactory$2$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $this_bind;
    final /* synthetic */ CancelScreen this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CancelScreen$viewFactory$2$7(a aVar, CancelScreen cancelScreen) {
        super(0);
        this.$this_bind = aVar;
        this.this$0 = cancelScreen;
    }

    public final void invoke() {
        boolean z10 = false;
        if (this.$this_bind.f32813c.getLineCount() > 1 || this.$this_bind.f32817g.getLineCount() > 1) {
            Button button = this.$this_bind.f32813c;
            j.f(button, "closeButton");
            a aVar = this.$this_bind;
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = aVar.f32814d.getWidth();
                button.setLayoutParams(layoutParams);
                Button button2 = this.$this_bind.f32817g;
                j.f(button2, "retryButton");
                a aVar2 = this.$this_bind;
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = aVar2.f32814d.getWidth();
                    button2.setLayoutParams(layoutParams2);
                    a aVar3 = this.$this_bind;
                    aVar3.f32814d.setReferencedIds(new int[]{aVar3.f32813c.getId(), this.$this_bind.f32817g.getId()});
                    z10 = true;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        CancelScreen cancelScreen = this.this$0;
        StepStyle h10 = cancelScreen.f26975a;
        a aVar4 = this.$this_bind;
        j.f(aVar4, "this");
        cancelScreen.j(h10, aVar4, z10);
    }
}
