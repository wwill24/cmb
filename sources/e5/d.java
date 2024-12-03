package e5;

import android.animation.ValueAnimator;
import com.coffeemeetsbagel.activity_reports.views.OnOffView;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnOffView f14581a;

    public /* synthetic */ d(OnOffView onOffView) {
        this.f14581a = onOffView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OnOffView.l(this.f14581a, valueAnimator);
    }
}
