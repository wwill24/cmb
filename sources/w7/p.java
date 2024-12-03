package w7;

import android.animation.ValueAnimator;
import com.appyvet.rangebar.RangeBar;

public final /* synthetic */ class p implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RangeBar f18299a;

    public /* synthetic */ p(RangeBar rangeBar) {
        this.f18299a = rangeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f18299a.r((float) q.k(this.f18299a.getLeftIndex(), (int) this.f18299a.getTickInterval(), (int) this.f18299a.getTickStart()), (float) q.k(((Integer) valueAnimator.getAnimatedValue()).intValue(), (int) this.f18299a.getTickInterval(), (int) this.f18299a.getTickStart()));
    }
}
