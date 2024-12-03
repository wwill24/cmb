package cf;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f18992a;

    /* renamed from: b  reason: collision with root package name */
    private long f18993b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f18994c;

    /* renamed from: d  reason: collision with root package name */
    private int f18995d;

    /* renamed from: e  reason: collision with root package name */
    private int f18996e;

    public i(long j10, long j11) {
        this.f18994c = null;
        this.f18995d = 0;
        this.f18996e = 1;
        this.f18992a = j10;
        this.f18993b = j11;
    }

    @NonNull
    static i b(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f18995d = valueAnimator.getRepeatCount();
        iVar.f18996e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f18978b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f18979c;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            return a.f18980d;
        }
        return interpolator;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f18992a;
    }

    public long d() {
        return this.f18993b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f18994c;
        return timeInterpolator != null ? timeInterpolator : a.f18978b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f18995d;
    }

    public int h() {
        return this.f18996e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j10, long j11, @NonNull TimeInterpolator timeInterpolator) {
        this.f18995d = 0;
        this.f18996e = 1;
        this.f18992a = j10;
        this.f18993b = j11;
        this.f18994c = timeInterpolator;
    }
}
