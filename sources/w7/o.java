package w7;

import android.animation.ValueAnimator;
import com.appyvet.rangebar.RangeBar;

public final /* synthetic */ class o implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RangeBar f18298a;

    public /* synthetic */ o(RangeBar rangeBar) {
        this.f18298a = rangeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f18298a.r((float) q.k(((Integer) valueAnimator.getAnimatedValue()).intValue(), (int) this.f18298a.getTickInterval(), (int) this.f18298a.getTickStart()), (float) q.k(this.f18298a.getRightIndex(), (int) this.f18298a.getTickInterval(), (int) this.f18298a.getTickStart()));
    }
}
