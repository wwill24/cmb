package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class d2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h2 f4813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f4814b;

    public /* synthetic */ d2(h2 h2Var, View view) {
        this.f4813a = h2Var;
        this.f4814b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4813a.a(this.f4814b);
    }
}
