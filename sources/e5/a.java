package e5;

import android.animation.ValueAnimator;
import com.coffeemeetsbagel.activity_reports.views.DottedCircleView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DottedCircleView f14578a;

    public /* synthetic */ a(DottedCircleView dottedCircleView) {
        this.f14578a = dottedCircleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DottedCircleView.h(this.f14578a, valueAnimator);
    }
}
