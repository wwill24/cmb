package com.withpersona.sdk2.inquiry.governmentid;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ti.b;

final class GovernmentIdInstructionsRunner$applyStyles$8$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ double $borderWidth;
    final /* synthetic */ GovernmentIdInstructionsRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdInstructionsRunner$applyStyles$8$1(GovernmentIdInstructionsRunner governmentIdInstructionsRunner, double d10) {
        super(0);
        this.this$0 = governmentIdInstructionsRunner;
        this.$borderWidth = d10;
    }

    public final void invoke() {
        View view = this.this$0.f25360b.f31962c;
        ViewGroup.LayoutParams layoutParams = this.this$0.f25360b.f31962c.getLayoutParams();
        double d10 = this.$borderWidth;
        GovernmentIdInstructionsRunner governmentIdInstructionsRunner = this.this$0;
        if (d10 > 0.0d) {
            layoutParams.height = (int) b.a(d10);
        } else {
            governmentIdInstructionsRunner.f25360b.f31962c.setVisibility(8);
        }
        view.setLayoutParams(layoutParams);
    }
}
