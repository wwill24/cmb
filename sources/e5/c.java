package e5;

import android.animation.ValueAnimator;
import com.coffeemeetsbagel.activity_reports.views.OnOffView;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnOffView f14580a;

    public /* synthetic */ c(OnOffView onOffView) {
        this.f14580a = onOffView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OnOffView.k(this.f14580a, valueAnimator);
    }
}
