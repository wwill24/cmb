package com.withpersona.sdk2.inquiry.governmentid;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ki.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CameraScreenRunner$showRendering$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $this_with;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$2(CameraScreenRunner cameraScreenRunner, a aVar) {
        super(0);
        this.this$0 = cameraScreenRunner;
        this.$this_with = aVar;
    }

    public final void invoke() {
        View o10 = this.this$0.f25282g;
        if (o10 != null) {
            a aVar = this.$this_with;
            ViewGroup.LayoutParams layoutParams = o10.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                bVar.height = 0;
                bVar.width = 0;
                bVar.f4152i = aVar.f31933n.getId();
                bVar.f4158l = aVar.f31933n.getId();
                bVar.f4174t = aVar.f31933n.getId();
                bVar.f4178v = aVar.f31933n.getId();
                o10.setLayoutParams(bVar);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }
}
