package c3;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class c extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f7924a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Animator.AnimatorListener> f7925b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<Animator.AnimatorPauseListener> f7926c = new CopyOnWriteArraySet();

    /* access modifiers changed from: package-private */
    public void a() {
        for (Animator.AnimatorListener onAnimationCancel : this.f7925b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f7925b.add(animatorListener);
    }

    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f7926c.add(animatorPauseListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f7924a.add(animatorUpdateListener);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        for (Animator.AnimatorListener next : this.f7925b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z10);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (Animator.AnimatorPauseListener onAnimationPause : this.f7926c) {
            onAnimationPause.onAnimationPause(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        for (Animator.AnimatorListener onAnimationRepeat : this.f7925b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        for (Animator.AnimatorPauseListener onAnimationResume : this.f7926c) {
            onAnimationResume.onAnimationResume(this);
        }
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z10) {
        for (Animator.AnimatorListener next : this.f7925b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z10);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f7924a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public void removeAllListeners() {
        this.f7925b.clear();
    }

    public void removeAllUpdateListeners() {
        this.f7924a.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f7925b.remove(animatorListener);
    }

    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f7926c.remove(animatorPauseListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f7924a.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
