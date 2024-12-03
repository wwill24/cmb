package com.withpersona.sdk2.inquiry.governmentid;

import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.k0;
import ki.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdReviewRunner$showRendering$1$10 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $this_with;
    final /* synthetic */ GovernmentIdReviewRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdReviewRunner$showRendering$1$10(e eVar, GovernmentIdReviewRunner governmentIdReviewRunner) {
        super(0);
        this.$this_with = eVar;
        this.this$0 = governmentIdReviewRunner;
    }

    /* access modifiers changed from: private */
    public static final void c(GovernmentIdReviewRunner governmentIdReviewRunner) {
        j.g(governmentIdReviewRunner, "this$0");
        governmentIdReviewRunner.i();
    }

    public final void invoke() {
        if (this.$this_with.f31970b.getLineCount() > 1 || this.$this_with.f31984t.getLineCount() > 1) {
            Button button = this.$this_with.f31970b;
            j.f(button, "acceptButton");
            e eVar = this.$this_with;
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = eVar.f31977j.getWidth();
                button.setLayoutParams(layoutParams);
                Button button2 = this.$this_with.f31984t;
                j.f(button2, "retryButton");
                e eVar2 = this.$this_with;
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = eVar2.f31977j.getWidth();
                    button2.setLayoutParams(layoutParams2);
                    e eVar3 = this.$this_with;
                    eVar3.f31977j.setReferencedIds(new int[]{eVar3.f31970b.getId(), this.$this_with.f31984t.getId()});
                    this.this$0.f25377b.f31978k.setAccessibilityTraversalAfter(l0.retry_button);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        k0.a(this.$this_with.f31970b, new a0(this.this$0));
    }
}
