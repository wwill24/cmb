package e5;

import android.animation.ValueAnimator;
import com.coffeemeetsbagel.activity_reports.views.MessageView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MessageView f14579a;

    public /* synthetic */ b(MessageView messageView) {
        this.f14579a = messageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        MessageView.e(this.f14579a, valueAnimator);
    }
}
