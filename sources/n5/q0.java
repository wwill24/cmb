package n5;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

public final /* synthetic */ class q0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16613a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f16614b;

    public /* synthetic */ q0(h1 h1Var, ViewGroup.LayoutParams layoutParams) {
        this.f16613a = h1Var;
        this.f16614b = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f16613a.Y2(this.f16614b, valueAnimator);
    }
}
