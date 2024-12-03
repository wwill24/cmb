package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.n0;

public class d extends q0 {

    class a extends o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f18390a;

        a(View view) {
            this.f18390a = view;
        }

        public void e(@NonNull n nVar) {
            d0.g(this.f18390a, 1.0f);
            d0.a(this.f18390a);
            nVar.W(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f18392a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18393b = false;

        b(View view) {
            this.f18392a = view;
        }

        public void onAnimationEnd(Animator animator) {
            d0.g(this.f18392a, 1.0f);
            if (this.f18393b) {
                this.f18392a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (n0.S(this.f18392a) && this.f18392a.getLayerType() == 0) {
                this.f18393b = true;
                this.f18392a.setLayerType(2, (Paint) null);
            }
        }
    }

    public d(int i10) {
        r0(i10);
    }

    private Animator s0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        d0.g(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, d0.f18395b, new float[]{f11});
        ofFloat.addListener(new b(view));
        a(new a(view));
        return ofFloat;
    }

    private static float t0(u uVar, float f10) {
        Float f11;
        if (uVar == null || (f11 = (Float) uVar.f18492a.get("android:fade:transitionAlpha")) == null) {
            return f10;
        }
        return f11.floatValue();
    }

    public void k(@NonNull u uVar) {
        super.k(uVar);
        uVar.f18492a.put("android:fade:transitionAlpha", Float.valueOf(d0.c(uVar.f18493b)));
    }

    public Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float f10 = 0.0f;
        float t02 = t0(uVar, 0.0f);
        if (t02 != 1.0f) {
            f10 = t02;
        }
        return s0(view, f10, 1.0f);
    }

    public Animator p0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        d0.e(view);
        return s0(view, t0(uVar, 1.0f), 0.0f);
    }

    public d() {
    }
}
