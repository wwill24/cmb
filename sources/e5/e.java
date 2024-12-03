package e5;

import android.animation.ValueAnimator;
import com.coffeemeetsbagel.activity_reports.views.PieView;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PieView f14582a;

    public /* synthetic */ e(PieView pieView) {
        this.f14582a = pieView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        PieView.d(this.f14582a, valueAnimator);
    }
}
